<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="java.sql.*,java.util.*,com.dao.*,javax.servlet.*"%>
<link rel="stylesheet" href="css/raw.css">
<title>history</title>
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
body {
  min-height: 100vh;
  position: relative;
  margin: 0;
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
footer {
  position: relative;
  bottom: 0;
}
</style>
</head>
<body>
<ul style="list-style: none;">
<li><a href="<%=temp %>jsp/dashboard.jsp">Dashboard</a></li>
<li><a href="<%=temp %>ProfileUpdate">update profile</a></li>
<li><a href="<%=temp %>RequestApproval">approve requests</a></li>
<li><a href="<%=temp %>RequestHistory">show requests history</a></li>
<li style="float:right"><a href="<%=temp %>Logout">logout</a></li>
</ul>
<content>
<%HttpSession sess = request.getSession(); ResultSet rs1 = (ResultSet)sess.getAttribute("rs1");%>
<div style="padding-top: 100px; padding-left: 15%;">
<table style="border: 1px solid black; padding: 10px; margin-top: 10px; center">
<tr><th>ID</th><th>FULL NAME</th><th>GENDER</th><th>WEIGHT</th><th>DOB</th><th>BTYPE</th><th>CONTACT</th>
<th>EMAIL</th><th>ADDRESS</th><th>DOCTOR</th><th>HOSPITAL</th><th>AUTOLOGOUS</th></tr>

<%while(rs1.next()==true){ %>
<tr><td><%=rs1.getString(1) %></td>
<td><%=rs1.getString(2)%> <%=rs1.getString(3) %></td>
<td><%=rs1.getString(4) %></td>
<td><%=rs1.getString(5) %></td>
<td><%=rs1.getDate(6) %></td>
<td><%=rs1.getString(7) %></td>
<td><%=rs1.getString(8) %></td>
<td><%=rs1.getString(9) %></td>
<td><%=rs1.getString(10) %></td>
<td><%=rs1.getString(11) %></td>
<td><%=rs1.getString(12) %></td>
<td><%=rs1.getInt(15) %></td></tr>
<%} %>
</table><br><br>
<a href="./jsp/dashboard.jsp">Dashboard</a>
</div>
</content>
<footer>
	<div class="fsz container-fluid sparrow footer" >
    	<div class="row">
         <div class="col-xs-10" >
         
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;
     	        <a href="https://www.facebook.com/" class="sz"><i class="fa fa-facebook"></i></a>
        	     <a class="sz" href="https://www.twitter.com/"><i class="fa fa-twitter"></i></a>&nbsp;&nbsp;
            	 <a href="https://www.instagram.com/" class="sz"><i class="fa fa-instagram"></i></a>
           	 </p>
             <p>A2O BLOOD BANK SOLUTIONS : 
             	<a class="material-icons sz" href="<%=temp %>jsp/dashboard.jsp">home</a>
                <a href="<%=temp %>contact.html" class="sz"><i class="material-icons">perm_phone_msg</i></a>
             </p>
         </div>
     	</div>
  	</div>
</footer></body>
</html>