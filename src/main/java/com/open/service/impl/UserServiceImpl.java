package com.open.service.impl;

import com.open.exception.InsertException;
import com.open.exception.UseremailDuplicateException;
import com.open.mapper.UserMapper;
import com.open.pojo.User;
import com.open.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public void addUser(User user) {
         //通过参数user获取尝试注册的用户名
//        String userEmail = "10086@qq.com";
        String username = "open";
        String userEmail = user.getEmail();
        // 调用userMapper.findByUsername()方法执行查询
        User result =  userMapper.getEmail(userEmail);
        if (result != null) {
            // 是：查询到了数据，表示用户名已经被占用，则抛出UsernameDuplicationException
           //throw new UsernameDuplicateException();
            System.out.println("查询到了数据表示用户名已经被占用");
            throw new UseremailDuplicateException("用户名已存在");
        }
        // 如果代码能执行到这一行，则表示没有查到数据，表示用户名未被注册，则允许注册
        // 创建当前时间对象：
        Date now = new Date();

        // 向参数user中补全数据：salt, password
        String salt = UUID.randomUUID().toString();
        System.out.println(salt+"--------------------");
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(md5Password);
        user.setEmail(userEmail);
        user.setUsername(username);
        user.setCreatedTime(now);

        Integer insert = userMapper.insert(user);
        System.out.println(insert);
        // 判断受影响的行数是否不为1
        if (insert != 1) {
            // 是：插入数据失败，则抛出InsertException
//            throw new InsertException();
            System.out.println("插入数据失败，则抛出InsertException");
            throw new InsertException();
        }


    }


    private String getMd5Password(String password, String salt) {
        // 加密标准：使用salt+password+salt作为被运算数据，循环加密3次
        String result = salt + password + salt;
        for (int i = 0; i < 3; i++) {
            result = DigestUtils.md5Hex(result);
            //即对密码进行加密了
        }
        System.err.println("\tpassword=" + password);
        System.err.println("\tsalt=" + salt);
        System.err.println("\tmd5Password=" + result);
        return result;
    }


    @Override
//    用户登录
    public User login(String email, String password) {
        // 日志
        System.err.println("UserServiceImpl.login()");
        // 基于参数username调用userMapper.findByUsername()查询用户数据
        User result = userMapper.getEmail(email);
        System.out.println("result"+result+"-------------------");

        // 判断查询结果(result)是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
//            throw new UserNotFoundException("登录失败，用户名不存在！");
            System.out.println("登录失败，用户名不存在！");
        }

        // 从查询结果(result)中获取盐值
        String salt = result.getSalt();
        // 基于参数password和盐值，调用getMd5Password()执行加密
        String md5Password = getMd5Password(password, salt);
        // 判断查询结果(result)中的密码和以上加密结果是否不一致
        if (!md5Password.equals(result.getPassword())) {
            // 是：抛出PasswordNotMatchException
//            throw new PasswordNotMatchException("登录失败，密码错误！");
            System.out.println("登录失败，密码错误！");
        }else {
            System.out.println("登录成功！！！！！");
            // 创建新的User对象
            User user = new User();
            // 将查询结果中的uid、username、avatar设置到新的User对象的对应的属性中
            user.setId(result.getId());
            user.setUsername(result.getUsername());
            user.setEmail(result.getEmail());
            
            // 返回新创建的User对象
            return user;
        }

        // 创建新的User对象
        User user = new User();
        // 将查询结果中的uid、username、avatar设置到新的User对象的对应的属性中
        user.setId(result.getId());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        // 返回新创建的User对象
        return user;


    }


    /**
     * 修改密码
     * @param email
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void changePassword( String email, String oldPassword, String newPassword) {
        System.err.println("UserServiceImpl.changePassword()");
        // 调用userMapper.findByUid()查询用户数据
        User result = userMapper.getEmail(email);
        // 判断查询结果(result)是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
//            throw new UserNotFoundException("修改密码失败，尝试访问的用户数据不存在！");
            System.out.println("修改密码失败，尝试访问的用户数据不存在！");
        }else {
            // 从查询结果(result)中取出盐值(salt)
            String salt = result.getSalt();
            // 基于参数oldPassword和盐值执行加密
            String oldMd5Password = getMd5Password(oldPassword, salt);
            if (!oldMd5Password.equals(result.getPassword())){
                // 判断以上加密结果与查询结果(result)中的密码是否不匹配
                // 是：抛出PasswordNotMatchException
//            throw new PasswordNotMatchException("修改密码失败，原密码错误！");
                System.out.println("修改密码失败，原密码错误！");
            }else {
                // 日志
                System.err.println("\t验证通过，更新密码：");
                // 基于参数newPassword和盐值执行加密
                String newMd5Password = getMd5Password(newPassword, salt);
                // 调用userMapper.updatePasswordByUid()执行更新密码（最后修改人是参数username），并获取返回值
                Integer rows = userMapper.updatePasswordByEmail(email,newMd5Password,new Date());
                // 判断返回结果是否不为1
                if (rows != 1) {
                    // 是：抛出UpdateException
//            throw new UpdateException("修改密码失败，更新密码时出现未知错误，请联系系统管理员！");
                    System.out.println("修改密码失败，更新密码时出现未知错误，请联系系统管理员！");
                }
            }
        }


    }

    @Override
    public void changeAvatar(Integer id, String username, String avatar) {
        // 调用userMapper.findByUid()查询用户数据
        User result = userMapper.findByid(id);
        // 判断查询结果(result)是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException
//            throw new UserNotFoundException("修改用户头像失败，尝试访问的用户数据不存在！");
            System.out.println("修改用户头像失败，尝试访问的用户数据不存在！");
        }



        // 调用userMapper.updateAvatarByUid()执行更新，并获取返回值
        Integer rows = userMapper.updateAvatarById(id,avatar,new Date());
        // 判断返回值是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException
//            throw new UpdateException("修改用户头像失败，更新头像时出现未知错误，请联系系统管理员！");
            System.out.println("修改用户头像失败，更新头像时出现未知错误，请联系系统管理员！");
        }

    }

}
