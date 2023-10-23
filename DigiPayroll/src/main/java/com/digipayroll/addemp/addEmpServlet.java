package com.digipayroll.addemp;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class addEmpServlet
 */
@WebServlet("/addEmpServlet")
public class addEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String fName = request.getParameter("fname");
		String lName = request.getParameter("lname");
		String StringAge = request.getParameter("age");
		int age = parseInt(StringAge);
		String category = request.getParameter("category");
		String subCategory = request.getParameter("subCategory");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String StringNum = request.getParameter("mobile");
		int num = parseInt(StringNum);
		String StringHr = request.getParameter("hours");
		int hr = parseInt(StringHr);
		RequestDispatcher dispatcher = null;
		Connection con = null;
//	  code for database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/digipayroll","root","root");
			
			
			PreparedStatement pst = con.prepareStatement("insert into emp(fName,lName,age,category,subCategory,dateOfJoining,mobileNum,hours) values(?,?,?,?,?,?,?,?)");
			
			pst.setString(1, fName);
			pst.setString(2, lName);
			pst.setInt(3, age);
			pst.setString(4, category);
			pst.setString(5, subCategory);
			pst.setString(6, dateOfJoining);
			pst.setInt(7, num);
			pst.setInt(8, hr);
			System.out.println(age);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("addEmp.jsp");
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