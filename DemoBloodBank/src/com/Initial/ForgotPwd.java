package com.Initial;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.BasicService;
import com.dao.DbmsService;

public class ForgotPwd extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String uid=req.getParameter("uid");
		
		String empid = req.getParameter("empid");
		
		String d = req.getParameter("doj");
		
		System.out.println("Date in String "+d);
		
		//Date ot = BasicService.changeToUtilDate(d);
		java.sql.Date dte=BasicService.changeToSqlDate(d);
		//System.out.println(d);
				
		System.out.println(dte + " Date of joining for user id " + uid+" for empid "+empid);
		
		boolean b=DbmsService.userPwdChk(uid, empid, dte);
		if(b==true){
			RequestDispatcher rd = req.getRequestDispatcher("Login.html");
			out.println("<h3 '>Password Retrival Successful.<br> a link has been sent to your registered Email to reset password!</h3>");
			rd.include(req, resp);
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("ForgotPasswd.html");
			out.println("<h3 '>Incorrect Details! Please enter again...</h3>");
			rd.include(req, resp);
		}
	}
}