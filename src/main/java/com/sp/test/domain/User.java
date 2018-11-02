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
	private String status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
