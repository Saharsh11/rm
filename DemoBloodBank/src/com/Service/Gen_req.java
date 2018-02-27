package com.Service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;

public class Gen_req extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println("----------- in Gen_req java page ------------");
		String id =(String) req.getAttribute("rrid");
		System.out.println("Gen_req : " + id);
		
		String rno = req.getParameter("rno");
		System.out.println("the room no is "+rno);
		
		String donorBType = req.getParameter("btype");
		System.out.println("Donor type selected "+donorBType);
		
		int bottles = Integer.parseInt(req.getParameter("volume"));
		System.out.println("Number of bottles selected "+bottles);
		String status = "OK";
		System.out.println("data inserted from the DbmsService.regInDb with type "+id);
		
		DbmsService.generateReq(id,rno,donorBType,bottles,status);
		System.out.println("data inserted from the Gen_req with type "+id);
		
		RequestDispatcher rd = req.getRequestDispatcher("./jsp/RequestDisplay.jsp");
		rd.forward(req, resp);
	}
}

