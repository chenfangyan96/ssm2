package com.sp.test.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5037541293603072628L;
	/** 主键 */
	private Long id;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 状态 */
	private int status;
	/**   新邮箱*/
	private  String email;
	/**激活码*/
	private  String validateCode;

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	/** 更新时间 */
	private Date updateTime;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
