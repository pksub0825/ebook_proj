package com.semiproj.comments.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.Controller;

public class MapController implements Controller{

	@Override
	public String requestProcess(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		/*
		 /inc/top.jsp 에 있는 Info 태그 클릭하면 이동
			=> /comments/Map.do =>MapController
		   				=>/comments/Map.jsp로 리다이렉트
		 */
		
		return "/comments/Map.jsp";
	}

	@Override
	public boolean isRedirect() {
		return false; //리다이렉트
	}

}
