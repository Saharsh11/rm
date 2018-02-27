package com.Initial;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;

public class Index extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String option =  req.getParameter("initial");
		
		if(option.equals("request")){
			RequestDispatcher rd= req.getRequestDispatcher("RequesterPage.html");
			//RequestDispatcher rd= req.getRequestDispatcher("jsp/Req_Register.jsp");
			rd.forward(req, resp);
		}else if(option.equals("login")) {
			RequestDispatcher rd= req.getRequestDispatcher("Login.html");
			rd.forward(req, resp);
		}
	}
}
