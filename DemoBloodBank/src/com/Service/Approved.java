package com.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DbmsService;

/**
 * Servlet implementation class Approved
 */
public class Approved extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approved() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id1=request.getParameter("id");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");  
		
		int n= DbmsService.moveToHistory(id1,"Approved");
		if(n==0){
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Request not approved due database error');");
			out.print("window.location='RequestApproval'");
			out.print("</script>");
		}else if(n==1){
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Request approved successfully');");
			out.print("window.location='RequestApproval'");
			out.print("</script>");
		}else{
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Request not approved due other error');");
			out.print("window.location='RequestApproval'");
			out.print("</script>");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
		}

}
