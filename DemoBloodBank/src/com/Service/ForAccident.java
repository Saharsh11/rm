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
import com.model.Requestee;

/**
 * Servlet implementation class ForAccident
 */
public class ForAccident extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForAccident() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();
		
//		Requestee r = (Requestee)sess.getAttribute("r");
		Requestee req=(Requestee)sess.getAttribute("req");
		Double total=0.0,pri=0.0;
		String rno = request.getParameter("rno");
		String btype = request.getParameter("btype");
		int nUnits = Integer.parseInt(request.getParameter("volume"));
		
		total = nUnits * DbmsService.getPrice(btype);
		sess.setAttribute("aPrice", total);
		String req_id ="GR" + DbmsService.getMaxId("GR");
		
		int n = DbmsService.placeOrder(req_id, req.getR_id(), rno, btype, nUnits, total,req);
		if(n==1){
			System.out.println("The code executed. ");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Request is placed please check your status!');");
			out.println("window.location='RequesterPage.html'");
			out.println("</script>");
			RequestDispatcher rd= request.getRequestDispatcher("./RequesterPage.html");
			rd.include(request, response);
		}else{
			System.out.println("The code not executed. ");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Request not placed please try again!');");
			out.println("window.location='RequesterPage.html'");
			out.println("</script>");
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
