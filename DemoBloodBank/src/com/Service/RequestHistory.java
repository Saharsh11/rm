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

public class RequestHistory extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		 
		ResultSet rs1= DbmsService.getHisRequesters();
		HttpSession session = req.getSession();
		session.setAttribute("rs1", rs1);
		
		RequestDispatcher rd = req.getRequestDispatcher("./jsp/request_history.jsp");
		rd.forward(req, resp);
	}
}
