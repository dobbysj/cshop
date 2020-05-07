package com.javalec.ex.Ecommand;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ERegicommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Edao edao = new Edao();
		
		String eTitle="";
		String eContent="";
		String eDate1="";
		String eDate2="";
		String path = "Z:/upload";
//				request.getSession().getServletContext().getRealPath("upload");
		int size = 1024 * 1024 * 10;
		String eImg_thumb="";
		String eImg_cont="";
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			eTitle = multi.getParameter("eTitle");
			eContent = multi.getParameter("eContent");
			eDate1 = multi.getParameter("eDate1");
			eDate2 = multi.getParameter("eDate2");
			
			Enumeration files = multi.getFileNames();
			String name1 = (String)files.nextElement();
			eImg_thumb = multi.getFilesystemName(name1);
			String name2 = (String)files.nextElement();
			eImg_cont = multi.getFilesystemName(name2);
			System.out.println("파일명 : "+eImg_thumb);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int check = edao.eventRegi(eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
		System.out.println(check);
	}

}
