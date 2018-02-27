<%@page import="com.model.Requestee"%>
<%@ page import = "java.sql.*,java.util.*,com.dao.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>for Accident</title>
<style type="text/css">
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}
li {
    float: left;
}
li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}
li a:hover:not(.active) {
	color: white;
    background-color: #111;
}

.sparrow{
background-color: #660012;
}
.footer{
position : absolute;
 top : 80%;
 bottom: 0px;
 left: 0px;
 right: 0px;
}
.sz{
font-size: 25px;
color: #DDE3F5;
}
.fsz{
color: #DDE3F5;
font-size: 12px;
}
.active {
    background-color: #4CAF50;
}
</style>
</head>
<body>
<form id="forAccident" action="forAccident" method="post">
<% Requestee r=(Requestee) session.getAttribute("r"); 
%>
<table>
	<tr><td><label for="rno">Enter Room number: </label></td>
		<td><input type="text" name="rno" id="rno" placeholder="Enter Room number" required></td></tr>
	<tr><td>Select from following blood type: </td>
		<td><select name="btype">
			<% ResultSet rs=(ResultSet)session.getAttribute("showBtype"); %>
			<% while(rs.next()){
			%><option value="<%=rs.getString(3) %>"><%=rs.getString(3) %></option><%} %> 
		</select></td></tr>
	<tr><td>Enter number of unit(s) required: </td>
		<td><input type="text" name="volume" placeholder="no. of bottles" required></td></tr>
	<tr><td><input type="submit" value="Submit"></td><td><input type="reset" value="Cancel"></td></tr>
</table>
</form>

<div class="fsz container-fluid sparrow footer" >
     <div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 20px">
                
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;
             	 <a href="https://www.facebook.com/"><i class="fa fa-facebook sz"></i></a>
                 <a href="https://www.twitter.com/"><i class="fa fa-twitter sz"></i></a>&nbsp;&nbsp;
                 <a href="https://www.instagram.com/"><i class="fa fa-instagram sz"></i></a></p>
             <p>A2O BLOOD BANK SOLUTIONS : <a class="material-icons sz" href="../Index.html">home</a></p>
         </div>
     </div>
  </div>
</body>
</html>