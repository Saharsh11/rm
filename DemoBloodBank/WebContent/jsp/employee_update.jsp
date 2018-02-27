<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="java.sql.*,java.util.*,com.dao.*,javax.servlet.*,com.model.*"%>

<title>Employee Update</title>
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
<!-- <link rel="stylesheet" href="css/raw.css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<style type="text/css">
body {
  min-height: 100vh;
  position: relative;
  margin: 0;
}
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
.sz{
font-size: 20px;
color: #DDE3F5;
}
.fsz{
color: #DDE3F5;
font-size: 10px;

}
.active {
    background-color: #4CAF50;
}
td {
padding-bottom: 10px;
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
<% Emp e = (Emp)session.getAttribute("emp"); %>
<content>
<div>
<form action="EmployeUpdate" method="post" id="emp_reg_form1" >

<h4 ><span style="color:'Brown';">Registering Employee into System: </span></h4>
<table STYLE="border: 0px;" class="spaceUnder">
<tr><td><label for="fname">Enter first name : </label></td><td><input type="text" name="fname" id="fname" value="<%=e.getE_fname() %>" required></td></tr>
<tr><td><label for="lname">Enter last name : </label></td><td><input type="text" name="lname" id="lname" value="<%=e.getE_lname() %>" required></td></tr>
<tr><td><label>Select gender : </label></td><td><input type="radio" name="gender" value="Male" selected><label for="Male" > male</label>
							 	<input type="radio" value="Female" name="gender"><label for="Female" > Female</label></td></tr>
<tr><td><label for="dob">Enter date of birth : </label></td><td><input type="date" name="dob" id="dob" value="<%=e.getE_dob() %>" required></td></tr>
<tr><td><label for="doj">Enter date of joining: </label></td><td><input type="date" name="doj" id="doj" value="<%=e.getE_doj() %>" required></td></tr>
<tr><td><label for="btype">Select blood type : </label></td>
<td><input type="text" name="btype" id="btype" value="<%=e.getE_btype() %>" required></td></tr>

<tr><td><label for="empContact">Contact number : </label></td><td><input type="text" name="empContact" id="empContact"  value="<%=e.getE_contact() %>"></td></tr>
<tr><td><label for="email">Email address : </label></td><td><input type="email" name="email" id="email"  value="<%=e.getE_eaddr() %>"></td></tr>

<tr><td><label for="addr">Address : </label></td><td><textarea name="addr" id="addr" required ><%=e.getE_addr() %></textarea></td></tr>
<tr><td><label for="recmail">Recovery Id : </label></td><td><input type="email" name="recmail" id="recmail"  value="<%=e.getE_recovery_id() %>"></td></tr>

<tr><td><label for="dis">Any Transmission Disease</label></td><td><input type="text" name="dis" id="dis"  value="<%=e.getDisease() %>"></td></tr>

<tr><td><label for="wname">Previous Work name* : </label></td><td><input type="text" name="wname" id="wname"  value="<%=e.getE_workedLocation()%>"></td></tr>

<tr><td><label for="wdesig">Previous Work designation* : </label></td><td><input type="text" name="wdesig" id="wdesig"  value="<%=e.getE_workedDesignation() %>"></td></tr>

<tr><td><label for="twexp">Total working experience(in years)** : </label></td><td><input type="text" name="twexp" id="twexp"  value="<%=e.getE_workedExp() %>"></td></tr>

<tr><td><button type="submit" name="sbt" id="sbt">update data</button></td><td><button type="reset" name="reset" id="reset" >Cancel</button></td></tr>
</table>
<p>* please enter null if no value to put<br>** please enter 0 if no value to put</p>
</form>
</div>
</content>

<footer>
	<div class="fsz container-fluid sparrow footer" >
    	<div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 10px">
         
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
</footer>
</body>
</html>