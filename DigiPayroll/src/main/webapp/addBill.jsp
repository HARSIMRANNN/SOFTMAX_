<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size:20px; text-align: center; background-image: url('hh.jpg'); margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; height: 100vh;">
 
  <form method="post" action="addBillServlet" name="myForm" method="post" action="addEmpServlet" onsubmit="validateForm()" style="max-width: 800px; padding: 50px; background-color:white; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);"> 
  <h1>Add New Bill</h1>
<table> 
<tr> 
<td> Employee Id </td> 
<td> <input type="number" name="empId"> </td> 
</tr> 

<tr> 
<td> Type</td> 
<td> <input type="text" name="type"> 
</td> 
</tr> 

<tr> 
<td> Amount </td> 
<td> <input type="number" name="amount"> 
</td> 
</tr>
<tr> 
<td> Month </td> 
<td> <input type="number" name="month"> 
</td> 
</tr>
<tr>
                <td> Type </td>
                <td>
                    <select name="type" >
                        <option value="null">null</option>
                        <option value="Food">Food</option>
                        <option value="WiFi">WiFi</option>
                        <option value="Travel">Travel</option>
                        
                    </select>
                </td>
            </tr>

<tr>
 <td>
 <button type="submit" style="background-color:#132743; color: white; border:1px solid black; padding: 10px 20px; border-radius: 3px; cursor: pointer; margin-top:40px;margin-left:120px;">
 Add
</button>
 </td>
</tr>


</table>
<br><br><a href="index.jsp" style="color:#352f44; text-decoration: none; ">Return to Homepage</a> 
</form> 


</body>
</html>