package com.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DbmsService;
import com.model.Emp;

/**
 * Servlet implementation class EmployeUpdate
 */
public class EmployeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n=0;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sess = request.getSession();
		Emp e = (Emp)sess.getAttribute("emp");
		e.setE_fname(request.getParameter("fname"));
		e.setE_lname(request.getParameter("lname"));
		e.setE_gender(request.getParameter("gender"));
		e.setE_dob(BasicService.changeToSqlDate(request.getParameter("dob")));
		e.setE_doj(BasicService.changeToSqlDate(request.getParameter("doj")));
		e.setE_btype(request.getParameter("btype"));
		e.setE_contact(request.getParameter("empContact"));
		e.setE_eaddr(request.getParameter("email"));
		e.setE_addr(request.getParameter("addr"));
		e.setE_recovery_id(request.getParameter("recmail"));
		if(request.getParameter("dis").equalsIgnoreCase("yes")) {e.setDisease(1);}else {e.setDisease(0);}
		e.setE_workedDesignation(request.getParameter("wdesig"));
		e.setE_workedLocation(request.getParameter("wname"));
		e.setE_workedExp(Integer.parseInt(request.getParameter("twexp")));
		n = DbmsService.updateEmp(e);
		System.out.println("Data updated int system!");
		if(n==1){
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/dashboard.jsp");
			out.println("<h4>Profile updated! </h4>");
			rd.include(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/dashboard.jsp");
			out.println("<h4>Profile not updated! </h4>");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
