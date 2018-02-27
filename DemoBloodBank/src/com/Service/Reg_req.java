package com.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;
import com.model.Requestee;

public class Reg_req extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		Requestee r=new Requestee();
		
		r.setR_fname(req.getParameter("fname"));
		r.setR_lname(req.getParameter("lname"));
		r.setR_gender(req.getParameter("gender"));
		r.setR_dob(BasicService.changeToSqlDate(req.getParameter("dob")));
		r.setR_btype(req.getParameter("btype"));
		r.setR_eaddr(req.getParameter("email"));
		r.setR_contact(req.getParameter("reqContact"));
		r.setR_addr(req.getParameter("addr"));
		
		if(req.getParameter("autologous")!=null) {r.setAutologous(1);}else {r.setAutologous(0);}
		if(req.getParameter("disease")!=null) {r.setQ1(1);}else {r.setQ1(0);}
		if(req.getParameter("donated")!=null) {r.setQ2(1);}else {r.setQ2(0);}
		if(req.getParameter("received")!=null) {r.setQ3(1);}else {r.setQ3(0);}
		
		if(req.getParameter("accident")!=null) {r.setAccident(1);}else {r.setAccident(0);}
		
		r.setR_hospital_name(req.getParameter("hname"));
		r.setR_doctor_name(req.getParameter("dname"));
		
		int n=DbmsService.regInDB(r);
		if(n>0) {
			
			System.out.println("data inserted from the DbmsService.regInDb");
			ResultSet rs=DbmsService.retriveDonorType(r.getR_btype());
			System.out.println("Reg_req : DbmsService.retriveDonorType executed");
			
			
			req.setAttribute("r",r);
			System.out.println(req.getAttribute(r.getR_id()));
			req.setAttribute("showBtype", rs);
			System.out.println("Reg_req : resultSet added to request");
			
			if(r.getAccident()==1){
				RequestDispatcher rd= req.getRequestDispatcher("jsp/forAccident.jsp");
				rd.forward(req, resp);
			}else{ 
				RequestDispatcher rd= req.getRequestDispatcher("jsp/forTransfusion.jsp");
				rd.forward(req, resp);
			}
			
			//RequestDispatcher rd= req.getRequestDispatcher("jsp/BloodRequestForm.jsp");
			//rd.forward(req, resp);
		}
	}
}
