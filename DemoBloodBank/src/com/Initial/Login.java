package com.Initial;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DbmsService;

public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession sess = req.getSession();
		if(sess.isNew()){
			System.out.println("New session ecountered !! ");
		}else{
			System.out.println("Exsisting session encountered !!");
		}
		
		String uname = req.getParameter("userid");
		//sess.setAttribute("uname", uname);
		String pwd = req.getParameter("pwd");
		
		if(DbmsService.chkCredentials(uname,pwd)==1){
			sess.setAttribute("username", uname);
			
			out.println("Login Successful");
			out.println("<h4>Welcome, "+sess.getAttribute("username")+"</h4>");
			RequestDispatcher rd= req.getRequestDispatcher("./jsp/dashboard.jsp");
			rd.include(req, resp);
//			out.println("<a href='category'>category</a>");
			
		}else if((DbmsService.chkCredentials(uname,pwd)==0)){
			out.println("<h2>Login Unsuccessful! <br><t>User Exists,incorrect userid or password !</h2>");
			//req.setAttribute("username", uname);
			RequestDispatcher rd= req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
			/*ResultSet rs = DbmsService.retriveType();
			req.setAttribute("resultset", rs);
			RequestDispatcher rd= req.getRequestDispatcher("jsp/req_register.jsp");
			rd.forward(req, resp);*/
		}else{
			out.println("<h2>Login Unsuccessful, User does not Exist. </h2>");
			RequestDispatcher rd= req.getRequestDispatcher("Login.html");
			rd.include(req, resp);
		}
	}
}
