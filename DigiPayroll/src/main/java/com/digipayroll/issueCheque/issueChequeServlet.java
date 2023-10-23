package com.digipayroll.issueCheque;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/issueChequeServlet")
public class issueChequeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String StringID = request.getParameter("empId");
		int empId = parseInt(StringID);
		 System.out.println("Here");
		
		
		String StringAmount = request.getParameter("amount");
		int amount = parseInt(StringAmount);
		
		String dateOfIssue = request.getParameter("dateOfIssue");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("viewBillDetails.jsp");
		Connection con = null;
//	  code for database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digipayroll","root","root");
			
			
			
			
			PreparedStatement pst = con.prepareStatement("insert into cheque(empIDForCheque,amount,dateOfIssue) values(?,?,?)");
			
			
			pst.setInt(1, empId);
			
			
			pst.setInt(2, amount);
			pst.setString(3, dateOfIssue);
			
			System.out.println(amount);
			
			int rowCount = pst.executeUpdate();
			
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
