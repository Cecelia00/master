package com.open.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user")
public class User implements Serializable{

	private static final long serialVersionUID =  4441507855737944698L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * 电子邮箱
	 */
	@Column(name = "email")
	private String email;

	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;

	@Column(name = "salt")
	private String salt;

	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 性别：0-女，1-男
	 */
	@Column(name = "gender")
	private Long gender;

	/**
	 * 手机号码
	 */
	@Column(name = "phone")
	private String phone;

	/**
	 * 头像
	 */
	@Column(name = "avatar")
	private String avatar;

	/**
	 * 创建时间
	 */
	@Column(name = "created_time")
	private Date createdTime;

	/**
	 * 最后修改时间
	 */
	@Column(name = "modified_time")
	private Date modifiedTime;

	/**
	 * 姓名
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 学号
	 */
	@Column(name = "student_id")
	private String studentId;


	public Long getId() {
    return id;
  }

	public void setId(Long id) {
    this.id = id;
  }


	public String getEmail() {
    return email;
  }

	public void setEmail(String email) {
    this.email = email;
  }


	public String getUsername() {
    return username;
  }

	public void setUsername(String username) {
    this.username = username;
  }


	public String getSalt() {
    return salt;
  }

	public void setSalt(String salt) {
    this.salt = salt;
  }


	public String getPassword() {
    return password;
  }

	public void setPassword(String password) {
    this.password = password;
  }


	public Long getGender() {
    return gender;
  }

	public void setGender(Long gender) {
    this.gender = gender;
  }


	public String getPhone() {
    return phone;
  }

	public void setPhone(String phone) {
    this.phone = phone;
  }


	public String getAvatar() {
    return avatar;
  }

	public void setAvatar(String avatar) {
    this.avatar = avatar;
  }


	public Date getCreatedTime() {
    return createdTime;
  }

	public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }


	public Date getModifiedTime() {
    return modifiedTime;
  }

	public void setModifiedTime(Date modifiedTime) {
    this.modifiedTime = modifiedTime;
  }


	public String getName() {
    return name;
  }

	public void setName(String name) {
    this.name = name;
  }


	public String getStudentId() {
    return studentId;
  }

	public void setStudentId(String studentId) {
    this.studentId = studentId;
  }

}
