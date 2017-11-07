package com.speaker.api.bean;

public class AuthenticationBean {

	private boolean authenticated = false;

	private int failureCode = -1;
	
	private static final int LOGIN_SUCCESS = 0;

	private static final int GENERAL_ERROR = -1;

	private static final int LOGIN_FAILED = 11;

	public AuthenticationBean(boolean isAuthenticated) {
		this.authenticated = isAuthenticated;
		if (this.authenticated){
			this.failureCode= LOGIN_SUCCESS;
		}
	}

	public AuthenticationBean() {
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public int getFailureCode() {
		return failureCode;
	}

	public void setFailureCode(int failureCode) {
		this.failureCode = failureCode;
	}
}
