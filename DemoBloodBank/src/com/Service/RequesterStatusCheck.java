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

/**
 * Servlet implementation class RequesterStatusCheck
 */
public class RequesterStatusCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequesterStatusCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		String rid = request.getParameter("reqId");
		HttpSession sess = request.getSession();
		
		ResultSet rs = DbmsService.getStatusByRequestId(rid);
		System.out.println("resultSet populated");
		if(rs==null){
			System.out.println("No data found in Database! ");
			out.println("No data found !");
			RequestDispatcher rd = request.getRequestDispatcher("./RequesterPage.html");
			rd.include(request, response);
		}else {
			System.out.println("data found in Database! ");
			out.println("data found!");
			try {
				while(rs.next()){
					out.println("data found! for request id "+rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("./jsp/requestStatus.jsp");
			sess.setAttribute("reqstatus", rs);
			rd.include(request, response);
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
