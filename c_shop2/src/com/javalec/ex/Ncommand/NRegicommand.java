package com.javalec.ex.Ncommand;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NRegicommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Ndao ndao = new Ndao();
		
		String ntitle = "";
		String ncontent = "";
		String path = "/Users/soojilee/upload";
//		String path = "Z:/upload";
		int size = 1024 * 1024 * 10;
		String nattch ="";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			ntitle = multi.getParameter("ntitle");
			ncontent = multi.getParameter("ncontent");

			Enumeration files = multi.getFileNames();
			String name1 = (String)files.nextElement();
			nattch = multi.getFilesystemName(name1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int check = ndao.notiRegi(ntitle, ncontent, nattch);
		System.out.println("공지등록 성공했니? "+check);
		
	}

}
