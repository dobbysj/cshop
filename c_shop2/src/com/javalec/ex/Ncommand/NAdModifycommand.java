package com.javalec.ex.Ncommand;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class NAdModifycommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Ndao ndao = new Ndao();
		
		int nid = 0;
		String ntitle ="";
		String ncontent = "";
		String nattch = "";
		String nattch_origin= "";
		String path = "Z:/upload";
		int size = 1024 * 1024 * 10;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			nid = Integer.parseInt(multi.getParameter("nid"));
			ntitle = multi.getParameter("ntitle");
			ncontent = multi.getParameter("ncontent");

			Enumeration files = multi.getFileNames();
			String name1 = (String)files.nextElement();
			nattch = multi.getFilesystemName(name1);
			System.out.println("nattch 값은? "+nattch);
			if(nattch==null) {
				nattch = multi.getParameter("nattch_origin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int check = ndao.notiModi(nid, ntitle, ncontent, nattch);
		System.out.println("공지 수정 성공했니? "+check);
		
	}

}
