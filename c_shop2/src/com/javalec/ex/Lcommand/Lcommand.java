package com.javalec.ex.Lcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Lcommand {

	public void execute(HttpServletRequest request, HttpServletResponse response);
	
}
