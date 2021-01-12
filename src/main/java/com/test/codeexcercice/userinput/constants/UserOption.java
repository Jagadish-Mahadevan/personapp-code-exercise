package com.test.codeexcercice.userinput.constants;

import java.util.stream.Stream;

public enum UserOption {

	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

	private int code;

	private UserOption(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static UserOption of(int code) {
		return Stream.of(values()).filter(c -> c.getCode() == code).findFirst().get();
	}
}
