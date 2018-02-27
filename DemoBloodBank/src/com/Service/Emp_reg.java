package com.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;
import com.model.Employee;

public class Emp_reg extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		int n,f = 0;
		String cid = null;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Employee e = new Employee();
		
		e.setE_fname(req.getParameter("fname"));
		e.setE_lname(req.getParameter("lname"));
		e.setE_gender(req.getParameter("gender"));
		e.setE_dob(BasicService.changeToSqlDate(req.getParameter("dob")));
		e.setE_doj(BasicService.changeToSqlDate(req.getParameter("doj")));
		e.setE_btype(req.getParameter("btype"));
		e.setE_contact(req.getParameter("empContact"));
		e.setE_eaddr(req.getParameter("email"));
		e.setE_pass(req.getParameter("pass"));

		if(e.getE_pass().length()<8||e.getE_pass().length()>20)
			f=0;
		else
			f=1;
		
		e.setE_addr(req.getParameter("addr"));
		e.setE_recovery_id(req.getParameter("recmail"));
		
		if(req.getParameter("disease")!=null) {e.setDisease(1);}else {e.setDisease(0);}
		
		if(req.getParameter("worked")!=null) {e.setE_workedEarlier("YES");}else {e.setE_workedEarlier("NO");}
		
		if(req.getParameter("wname")!=null) {e.setE_workedLocation(req.getParameter("wname"));}else {e.setE_workedLocation("no location");}

		if(req.getParameter("wdesig")!=null) {e.setE_workedDesignation(req.getParameter("wdesig"));}else {e.setE_workedDesignation("no designation");}

		if(req.getParameter("twexp")!=null) {e.setE_workedExp(Integer.parseInt(req.getParameter("twexp")));}else {e.setE_workedExp(0);}
		
		out.println(e.toString());

		if(f==1){
		n=DbmsService.EmpInDb(e,cid);}else{n=0;}
		if(n>0){
			System.out.println("Service-Employee : Data is added in DataBase via EmpInDb()");
			out.println("Employe enrolled into System!<br>");
			out.println("Your login id is "+ cid);
			RequestDispatcher rd= req.getRequestDispatcher("Login.html");
			rd.forward(req, resp);
		}else{
			System.out.println("Data in not added");
			out.println("Employe Data is not accurate please try again!");
			RequestDispatcher rd= req.getRequestDispatcher("jsp/EmployeeRegister.jsp");
			rd.forward(req, resp);
		}
	}
}