package com.javalec.ex.Ecommand;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.Ndao.Ndao;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class EAdModifycommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Edao edao = new Edao();
		
		int eId = 0;
		String eTitle ="";
		String eContent = "";
		String eImg_thumb = "";
		String eImg_thumb2 = "";
		String eImg_cont= "";
		String eImg_cont2= "";
		String eDate1="";
		String eDate2="";
		String eDate12="";
		String eDate22="";
		String path = "/Users/soojilee/upload";
//		String path = "Z:/upload";
		int size = 1024 * 1024 * 10;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			eId = Integer.parseInt(multi.getParameter("eId"));
			eTitle = multi.getParameter("eTitle");
			eContent = multi.getParameter("eContent");
			
			eDate1 = multi.getParameter("eDate1");//시작날짜 새로 받은거
			eDate12 = multi.getParameter("eDate12");//시작날짜 기존거
			if(eDate1.equals("")) {//만약 새로 받은게 없으면
				eDate1 = eDate12;//기존거넣기
			}
			
			eDate2 = multi.getParameter("eDate2");
			if(eDate2.equals("")) {
				eDate2 = multi.getParameter("eDate22");
			}
			
			
//			이미지
			eImg_thumb = multi.getFilesystemName("eImg_thumb");
			eImg_thumb2 = multi.getParameter("eImg_thumb2");
			if(eImg_thumb==null) {
				eImg_thumb = eImg_thumb2;
			}
			System.out.println("thumb : "+eImg_thumb);
			
			
			eImg_cont = multi.getFilesystemName("eImg_cont");
			eImg_cont2 = multi.getParameter("eImg_cont2");
			if(eImg_cont==null) {
				eImg_cont = eImg_cont2;
			}
			System.out.println("cont : "+eImg_cont);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int check = edao.evModi(eId, eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
		System.out.println("이베느 수정 성공했니? "+check);

	}

}
