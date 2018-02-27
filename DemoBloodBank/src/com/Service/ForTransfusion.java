package com.Service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.DbmsService;
import com.model.Requestee;

/**
 * Servlet implementation class ForTransfusion
 */
public class ForTransfusion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForTransfusion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		PrintWriter out = response.getWriter();
//		Requestee r = (Requestee)sess.getAttribute("r");
		Requestee req=(Requestee)sess.getAttribute("req");
		Double total=0.0,pri=0.0;
		String rno = request.getParameter("rno");
		String typeCause=(String)sess.getAttribute("typeOfTransfusion");
		String creason = request.getParameter("type");
		String btype = request.getParameter("btype");
		int nUnits = Integer.parseInt(request.getParameter("volume"));
		
		if(typeCause.equals("Red BLood cell Transfusion")){
//			pri=DbmsService.getPrice(btype);
			total = nUnits * DbmsService.getPrice(btype);;
		}else{
//			pri=DbmsService.getPrice(typeCause);
			total = nUnits * DbmsService.getPrice(typeCause);
		}
		sess.setAttribute("tPrice", total);
		String req_id ="GR" + DbmsService.getMaxId("GR");
		
		int n = DbmsService.placeOrder(req_id,req.getR_id(),rno,typeCause,creason,btype,nUnits,total,req);
		if(n==-1){
			System.out.println("The requester not registered. ");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Requester is not registered!');");
			out.println("window.location='RequesterPage.html'");
			out.println("</script>");
			RequestDispatcher rd= request.getRequestDispatcher("./RequesterPage.html");
			rd.include(request, response);
		}else if(n==1){
			System.out.println("The code executed. ");
			out.println("<script type=\"text/javascript\">");
			
			out.println("alert('Request is placed with id "+req_id+" please check your status!');");
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
