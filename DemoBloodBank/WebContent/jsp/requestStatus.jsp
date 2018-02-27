<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="java.sql.*,java.util.*,com.dao.*,javax.servlet.*"%>
<title>Request Status</title>
<%
String temp;
String url=request.getRequestURL().toString();
System.out.println(url);
List<String> al=Arrays.asList(url.split("/"));
if(al.get(al.size()-2).equals("jsp"))
{
	temp="./";
}
else
{
	temp="";
}
%>
<link rel="stylesheet" href="css/raw.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
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

<% HttpSession sess = request.getSession();
ResultSet rs1 = (ResultSet) sess.getAttribute("reqstatus"); %>
<form>
<table style="border: none;">
<%while(rs1.next()==true) {%>
<tr><td>Request ID: </td><td><%=rs1.getString(1) %></td></tr>
<tr><td>Requester ID: </td><td><%=rs1.getString(2) %></td></tr>
<tr><td>Room number: </td><td><%= rs1.getString(3)%></td></tr>
<tr><td>Blood request type: </td><td><%=rs1.getString(4) %></td></tr>
<tr><td>Transfusion type: </td><td><%=rs1.getString(5) %></td></tr>
<tr><td>Reason: </td><td><%=rs1.getString(6) %></td></tr>
<tr><td>Blood Group requested: </td><td><%=rs1.getString(7) %></td></tr>
<tr><td>Total number of unit(s): </td><td><%=rs1.getInt(8) %></td></tr>
<tr><td>Total price: </td><td><%=rs1.getDouble(9) %></td></tr>
<tr><td>Status: </td><td><%=rs1.getString(10) %></td></tr>
</table>
<% } %>
</form>

<div class="fsz container-fluid sparrow footer" >
     <div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 20px">
         
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;<a href="https://www.facebook.com/"><i class="fa fa-facebook sz"></i></a>
                 <a href="https://www.twitter.com/"><i class="fa fa-twitter sz"></i></a>&nbsp;&nbsp;<a href="https://www.instagram.com/"><i class="fa fa-instagram sz"></i></a></p>
             <p>A2O BLOOD BANK SOLUTIONS : <a class="material-icons sz" href="./Index.html">home</a>
             </p>
         </div>
     </div>
  </div>
</body>
</html>