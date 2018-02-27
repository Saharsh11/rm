package com.Service;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DbmsService;

public class RequestApproval extends HttpServlet{
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		 
		ResultSet rs= DbmsService.getRequesters();
		HttpSession session = req.getSession();
		session.setAttribute("Req_rs", rs);
		System.out.println(("Request Approval : resultset loaded"));
		RequestDispatcher rd = req.getRequestDispatcher("./jsp/request_approval.jsp");
		rd.forward(req, resp);
	}

}
