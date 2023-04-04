package com.open.mapper;


import com.open.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * 查询全部数据
     * @return user
     */
    //    @Select("select * from t_user where id = #{id}")
     List<User> getAll();

    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据email查询是否有重复
     * @param email
     * @return
     */
   User getEmail(String email);

    /**
     * 更新用户的密码
     * @param email 用户的email
     * @param password 新的密码
     * @param modifiedTime 最后修改时间
     * @return 受影响的行数
     */
    Integer updatePasswordByEmail(
            @Param("email") String email,
            @Param("password") String password,
            @Param("modifiedTime") Date modifiedTime
    );

    /**
     * 根据用户id查询用户数据
     * @param uid 用户id
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User findByid(Integer uid);


    /**
     * 更新用户的个人资料
     * @param user 封装了用户的id和新个人资料的对象，可以更新的属性有：手机号码，电子邮箱，性别
     * @return 受影响的行数
     */
    Integer updateInfoById(User user);


    /**
     * 更新用户头像
     * @param id 用户Id
     * @param avatar 头像路径
     * @param modifiedTime 修改时间
     * @return
     */
    Integer updateAvatarById(
            @Param("id") Integer id,
            @Param("avatar") String avatar,
            @Param("modifiedTime") Date modifiedTime
    );



}
