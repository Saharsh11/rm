package com.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;

public class Ind_emp_login extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ResultSet rs = DbmsService.retriveType();
		req.setAttribute("resultset", rs);
		
		RequestDispatcher rd= req.getRequestDispatcher("./jsp/Emp_register.jsp");
		rd.forward(req, resp);
	}
}
