<%@page import="java.sql.*,java.util.*,com.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=DButil.getMyConnection();

%>
<div>
<form action="Reg_req" method="post">
<table>
<tr><td><h2 style="color:'Brown'; border: 2px dotted #006400; border-radius: 10; background-color: #7CFC00;">Register new Requestee into System: </h2></td></tr>
<tr><td><label for="fname">Enter First name : </label></td><td><input type="text" name="fname" id="fname" required></td></tr>
<tr><td><label for="lname">Enter Last name : </label></td><td><input type="text" name="lname" id="lname" required></td></tr>
<tr><td><label></label></td><td></td><td></td></tr>
<tr><td><label for="dob">Enter D.O.B : </label></td><td><input type="date" name="dob" id="dob" min="01-01-1917" required></td></tr>
<tr><td><label for="btype">Select Blood Type : </label></td>
<td><select name="btype">
<% ResultSet rs=(ResultSet)request.getAttribute("resultset");
while(rs.next()){
%><option value="<%=rs.getString(2) %>"><%=rs.getString(2) %></option><%} %>
</select></td></tr>
<tr><td><label for="addr">Enter Address : </label></td><td><textarea name="addr" id="addr" required></textarea></td></tr>
<!-- <tr><td><label for="pwd">Enter Password : </label></td><td><input type="password" name="pwd" id="pwd" required></td></tr>
<tr><td><label for="repwd">Re-enter Password : </label></td><td><input type="password" name="repwd" id="repwd"></td></tr> -->
<tr><td><button type="submit" name="sbt" id="sbt">Register Requestee</button></td><td><button type="submit" name="reset" id="reset">Cancel</button></td></tr>
</table>
</form>
</div>
</body>
</html>