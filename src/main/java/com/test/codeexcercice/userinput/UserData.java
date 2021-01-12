package com.test.codeexcercice.userinput;

public final class UserData {

	private final int code;
	private final String params;
	
	public UserData(int code) {
		this.code = code;
		this.params = null;
	}

	public UserData(int code, String params) {
		super();
		this.code = code;
		this.params = params;
	}

	public int getCode() {
		return code;
	}

	public String getParams() {
		return params;
	}

}
