package com.test.codeexcercice.userinput.strategy;

import com.test.codeexcercice.model.Response;

public interface PersonStrategy<T> {

	public Response<T> process(String params);
	
	default public String[] getParams(String params) {
		return params == null ? null : params.split(",");
	}
}
