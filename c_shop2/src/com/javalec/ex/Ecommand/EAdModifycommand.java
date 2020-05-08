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
		String path = "Z:/upload";
		int size = 1024 * 1024 * 10;
		
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
			eId = Integer.parseInt(multi.getParameter("eId"));
			eTitle = multi.getParameter("eTitle");
			eContent = multi.getParameter("eContent");
			
			eDate1 = multi.getParameter("eDate1");
			System.out.println("eDate1의 값입니다..."+eDate1);
			eDate12 = multi.getParameter("eDate12");
			System.out.println("eDate12의 값입니다..."+eDate12);
			if(eDate1.equals("")) {
				eDate1 = eDate12;
			}
			System.out.println("eDate1값...."+eDate1);
			
			eDate2 = multi.getParameter("eDate2");
			if(eDate2.equals("")) {
				eDate2 = multi.getParameter("eDate22");
			}
			
			eImg_thumb = multi.getFilesystemName("eImg_thumb");
			eImg_thumb2 = multi.getParameter("eImg_thumb2");
			if(eImg_thumb==null) {
				eImg_thumb = eImg_thumb2;
			}
			System.out.println("썸네일 미 수정했을 때 thumb : "+eImg_thumb);
			eImg_cont = multi.getFilesystemName("eImg_cont");
			eImg_cont2 = multi.getParameter("eImg_cont2");
			if(eImg_cont==null) {
				eImg_cont = eImg_cont2;
			}
			System.out.println("썸네일 미 수정했을 때 cont : "+eImg_cont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int check = edao.evModi(eId, eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
		System.out.println("이베느 수정 성공했니? "+check);

	}

}
