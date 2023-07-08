package com.mountblue.saurabh.model;

public class User {
	private String userId, Password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", Password=" + Password + "]";
	}

}
