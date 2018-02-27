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
import com.model.Emp;

/**
 * Servlet implementation class ProfileUpdate
 */
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdate() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		String id1=request.getParameter("id");
		PrintWriter out = response.getWriter();

		HttpSession sess = request.getSession();

		String crid = (String) sess.getAttribute("uname");
		
		Emp e = new Emp();
		
		ResultSet rs2 = DbmsService.empById(crid);
		try {
			rs2.next();
			e.setE_id(rs2.getString(1));
			e.setE_fname(rs2.getString(2));
			e.setE_lname(rs2.getString(3));
			e.setE_gender(rs2.getString(4));
			e.setE_dob(rs2.getDate(5));
			e.setE_doj(rs2.getDate(6));
			e.setE_btype(rs2.getString(7));
			e.setE_contact(rs2.getString(8));
			e.setE_eaddr(rs2.getString(9));
			e.setE_addr(rs2.getString(10));
			e.setE_recovery_id(rs2.getString(11));
			e.setDisease(rs2.getInt(12));
			e.setE_workedEarlier(rs2.getString(13));
			e.setE_workedExp(rs2.getInt(16));
			e.setE_workedDesignation(rs2.getString(14));
			e.setE_workedLocation(rs2.getString(15));
			e.setAdmin(rs2.getInt(17));
		} catch (SQLException ex) {

			ex.printStackTrace();
		}
		sess.setAttribute("emp",e);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/employee_update.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
