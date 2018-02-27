<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,com.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Blood Request Form page 1/2 :- </h2>
<%
Connection conn=DButil.getMyConnection();

%>
<div>
<form action="Reg_req" method="post" id="req_reg_form1">

<h2 ><span style="color:'Brown'; border: 2px dotted #006400; border-radius: 10; background-color: #7CFC00;">Register Requester into System: </span></h2>
<table>
<tr><td><label for="fname">Enter First name : </label></td><td><input type="text" name="fname" id="fname" placeholder="First Name" required></td></tr>
<tr><td><label for="lname">Enter Last name : </label></td><td><input type="text" name="lname" id="lname" placeholder="Last Name" required></td></tr>
<tr><td>Select Gender : </td> 
								  <td><input type="radio" name="gender" value="Male"><label for="Male" > male</label>
								 	<input type="radio" value="Female" name="gender"><label for="Female" > Female</label></td></tr>
<tr><td><label for="dob">Enter Date of Birth : </label></td><td><input type="date" name="dob" id="dob" min="01-01-1917" placeholder="YYYY-MM-DD" required></td></tr>
<tr><td><label for="btype">Select Blood Type : </label></td>
<td><select name="btype">

<% ResultSet rs=(ResultSet)request.getAttribute("resultset");
while(rs.next()){
%><option value="<%=rs.getString(2) %>"><%=rs.getString(2) %></option><%} %>
</select></td></tr>
<tr><td><label for="reqContact">Enter your Contact number : </label></td><td><input type="text" name="reqContact" id="reqContact"  placeholder="+91-"></td></tr>
<tr><td><label for="email">Enter your email address : </label></td><td><input type="email" name="email" id="email"  placeholder="abc@gmail.com"></td></tr>
<tr><td><label for="addr">Enter your Address : </label></td><td><textarea name="addr" id="addr" required ></textarea></td></tr>
<tr><td><label for="hname">Enter Hospital name : </label></td><td><input type="text" name="hname" id="hname"  placeholder="Enter full hospital Name"></td></tr>
<tr><td><label for="dname">Enter Doctor name : </label></td><td><input type="text" name="dname" id="dname"  placeholder="Doctor Name"></td></tr>


<tr><td>Tick the appropriate option(s) : </td>

<tr><td></td><td><input type="checkbox" name="autologous" id="autologous"><label for="autologous">Are you a Autologous donor?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="disease" id="disease"><label for="dis">Do you have any Transmission Disease?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="donated" id="donated"><label for="received"> you ever donated blood?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="received" id="received"><label>Have you ever received blood?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="accident" id="accident"><label>For Accidental case</label></td></tr>

<tr><td><button type="submit" name="sbt" id="sbt">Submit form</button></td><td><button type="reset" name="reset" id="reset">Cancel</button></td></tr>
</table>
</form>
</div>
</body>
</html>