package com.javalec.ex.Ecommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.EDto.Edto;

public class EAdListcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Edao edao = new Edao();
		//페이징 관련 
		//출력할 페이지
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		//페이지당 게시물수
		int limit=10;
		//페이지 레인지
		int range=10;
		//전체 게시글 카운트
		int listcount = edao.listCount_ad(0); //어드민페이지 전체 이벤트 게시글 카운트
		int inprog_lc = edao.listCount_ad(1); //어드민페이지 진행중인 이벤트 게시글 카운트
		int end_lc = listcount - inprog_lc; //어드민페이지 종료된 이벤트 게시글 카운트
		//전체 레인지의 최종 페이지 넘버
		int maxpage = ( (listcount - 1) / limit ) + 1;
		//한 레인지의 처음 페이지 넘버
		int startpage = ((page-1)/range)*range+1;
		//한 레인지의 마지막 페이지넘버
		int endpage = maxpage;
		if(endpage>startpage+range-1) endpage = startpage+range-1;
		
		//출력 관련
		ArrayList<Edto> elist = new ArrayList<Edto>();
		elist = edao.eventList2(page, limit);
		System.out.println("사이즈 : "+elist.size());
		
		//리퀘스트에 담아 보내기
		request.setAttribute("elist", elist);
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("inprog_lc", inprog_lc);
		request.setAttribute("end_lc", end_lc);
	}

}
