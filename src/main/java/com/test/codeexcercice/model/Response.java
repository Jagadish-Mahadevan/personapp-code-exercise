package com.test.codeexcercice.model;

public class Response<Body> {

	private String resultMessage;
	private Body body;

	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Response [resultMessage=" + resultMessage + ", body=" + body + "]";
	}
}
