package com.digipayroll.addbill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addBillServlet
 */
@WebServlet("/addBillServlet")
public class addBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String StringID = request.getParameter("empId");
		int empId = parseInt(StringID);
		
		String type = request.getParameter("type");
		
		String StringAmount = request.getParameter("amount");
		int amount = parseInt(StringAmount);
		
		String StringMn = request.getParameter("month");
		int month = parseInt(StringMn);
		
		String StringYr = request.getParameter("year");
		int year = parseInt(StringYr);
		
		RequestDispatcher dispatcher = null;
		Connection con = null;
//	  code for database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digipayroll","root","root");
			
					
			PreparedStatement pst = con.prepareStatement("insert into bill(empIDForBill,type,amount,month,year) values(?,?,?,?,?)");
			
			
			pst.setInt(1, empId);
			pst.setString(2, type);
			
			pst.setInt(3, amount);
			pst.setInt(4, month);
			pst.setInt(5, year);
			
			System.out.println(amount);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("addBill.jsp");
			if(rowCount>0)
			{
				request.setAttribute("status", "success");
			}
			else {
				request.setAttribute("status", "failed");
			}
			 dispatcher.forward(request, response);
			}
		
		catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private int parseInt(String parameter) {
	    try {
	        return Integer.parseInt(parameter);
	    } catch (NumberFormatException e) {
	        // Handle the case where the input string is not a valid integer
	        e.printStackTrace(); // You can log the exception or handle it as needed
	        return 0; // Default value if parsing fails
	    }
	}

}
