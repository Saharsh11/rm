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
import javax.servlet.http.HttpSession;

import com.dao.DbmsService;
import com.model.Requestee;

public class RequesterRegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession sess = req.getSession();
		Requestee r=new Requestee();
		
		r.setR_fname(req.getParameter("fname"));
		r.setR_lname(req.getParameter("lname"));
		r.setR_gender(req.getParameter("gender"));
		r.setR_weight(req.getParameter("weight"));
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
		sess.setAttribute("req", r);
//		int n=DbmsService.regInDB(r);
//		if(n>0) {	
			System.out.println("data to be inserted from the DbmsService.regInDb");
			ResultSet rs=DbmsService.retriveDonorType(r.getR_btype());
			System.out.println("RequeterRegisterController : DbmsService.retriveDonorType executed");
			
			sess.setAttribute("r",r);
			System.out.println(r.getR_id());
			sess.setAttribute("showBtype", rs);
			System.out.println("RequeterRegisterController : donor type added to session");
			
			String transfusionType = req.getParameter("typeOfTransfusion");
			System.out.println("RequeterRegisterController: transfusion option taken");
			sess.setAttribute("typeOfTransfusion", transfusionType);
			System.out.println("RequeterRegisterController: transfusion set in session");
			ResultSet rs1=DbmsService.retriveCause(transfusionType);
			
			System.out.println("RequeterRegisterController: transfusion added in rs1");
			
			sess.setAttribute("cause", rs1);
			System.out.println("RequeterRegisterController: cause set in sess");
			if(r.getAccident()==1){
				System.out.println("RequeterRegisterController: accident case ");
				RequestDispatcher rd= req.getRequestDispatcher("jsp/forAccident.jsp");
				rd.forward(req, resp);
			}else{
				System.out.println("RequeterRegisterController: transfusion case ");
				RequestDispatcher rd= req.getRequestDispatcher("jsp/forTransfusion.jsp");
				rd.forward(req, resp);
			}
			
			//RequestDispatcher rd= req.getRequestDispatcher("jsp/BloodRequestForm.jsp");
			//rd.forward(req, resp);
//		}
	}
}
