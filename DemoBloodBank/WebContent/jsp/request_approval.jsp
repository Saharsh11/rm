<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="java.sql.*,java.util.*,com.dao.*,javax.servlet.*"%>
<title>Approve requests</title>
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

<%HttpSession sess = request.getSession(); ResultSet rs = (ResultSet)sess.getAttribute("Req_rs");%>
<ul style="list-style: none;">
<li><a href="./jsp/dashboard.jsp">Dashboard</a></li>
<li><a href="<%=temp %>ProfileUpdate">update profile</a></li>
<li><a href="<%=temp %>RequestApproval">approve requests</a></li>
<li><a href="<%=temp %>RequestHistory">show requests history</a></li>
<li style="float:right"><a href="<%=temp %>Logout">logout</a></li>
</ul>
<div style="padding-top: 100">
<table style="border: 1px solid black;">
<tr><th>ID</th><th>FULL NAME</th><th>GENDER</th><th>WEIGHT</th><th>DOB</th><th>BTYPE</th><th>CONTACT</th>
<th>EMAIL</th><th>ADDRESS</th><th>DOCTOR</th><th>HOSPITAL</th><th>AUTOLOGOUS</th><th>APPROVE</th></tr>

<%while(rs.next()==true){ %>
<tr><td><%=rs.getString(1) %></td><td><%=rs.getString(2)%> <%=rs.getString(3) %></td>
<td><%=rs.getString(4) %></td><td><%=rs.getString(5) %></td><td><%=rs.getDate(6) %></td><td><%=rs.getString(7) %></td><td><%=rs.getString(8) %></td>
<td><%=rs.getString(9) %></td><td><%=rs.getString(10) %></td><td><%=rs.getString(11) %></td><td><%=rs.getString(12) %></td>
<td><%=rs.getInt(16) %></td><td><a href="Approved?id=<%=rs.getString(1) %>">approved</a></td></tr>
<%} %>
</table>
<br><br>
<a href="./jsp/dashboard.jsp">Dashboard</a>
</div>
<div class="fsz container-fluid sparrow footer" >
     <div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 20px">
         
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;<a href="https://www.facebook.com/"><i class="fa fa-facebook sz"></i></a>
                 <a href="https://www.twitter.com/"><i class="fa fa-twitter sz"></i></a>&nbsp;&nbsp;<a href="https://www.instagram.com/"><i class="fa fa-instagram sz"></i></a></p>
             <p>A2O BLOOD BANK SOLUTIONS : <a class="material-icons sz" href="<%=temp %>jsp/dashboard.jsp">home</a>
                <a href="<%=temp %>contact.html"><i class="material-icons sz">perm_phone_msg</i></a>
             </p>
         </div>
     </div>
  </div>
</body>
</html>