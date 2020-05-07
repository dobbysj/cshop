package com.javalec.ex.Ecommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ecommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
