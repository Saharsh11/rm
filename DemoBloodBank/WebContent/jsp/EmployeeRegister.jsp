<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,com.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script type="text/javascript" src="../js/EmploymentDetailsForm.js"></script>
</head>
<body>
<!-- <h2>Employee registration form page 1/2 :- </h2> -->
<%
Connection conn=DButil.getMyConnection();
%>
<div>
<form action="../Emp_reg" method="post" id="emp_reg_form1" >

<h2 ><span style="color:'Brown'; border: 2px dotted #006400; border-radius: 10; background-color: #7CFC00;">Registering Employee into System: </span></h2>
<table>
	<tr><td><label for="fname">Enter First name : </label></td><td><input type="text" name="fname" id="fname" placeholder="First Name" required></td></tr>
	<tr><td><label for="lname">Enter Last name : </label></td><td><input type="text" name="lname" id="lname" placeholder="Last Name" required></td></tr>
	<tr><td>Select Gender : </td> 
								  <td><input type="radio" name="gender" value="Male"><label for="Male" > male</label>
								 	<input type="radio" value="Female" name="gender"><label for="Female" > Female</label></td></tr>
	<tr><td><label for="dob">Enter Date of Birth : </label></td><td><input type="date" name="dob" id="dob" placeholder="YYYY-MM-DD" required></td></tr>
	<tr><td><label for="doj">Enter Date of Joining: </label></td><td><input type="date" name="doj" id="doj" placeholder="YYYY-MM-DD" required></td></tr>
	<tr><td><label for="btype">Select Blood Type : </label></td>
		<td><select name="btype">
		<% ResultSet rs1 = DbmsService.retriveType();
			while(rs1.next()){
		%><option value="<%=rs1.getString(2) %>"><%=rs1.getString(2) %></option><%} %>
		</select></td></tr>
	<tr><td><label for="empContact">Enter your Contact number : </label></td><td><input type="text" name="empContact" id="empContact"  value="+91-"></td></tr>
	<tr><td><label for="email">Enter your email address : </label></td><td><input type="email" name="email" id="email"  placeholder="abc@gmail.com"></td></tr>
	<tr><td><label for="pass">Enter your password : </label></td><td><input type="password" name="pass" id="pass"  placeholder="password"></td></tr>
	<tr><td><label for="pass">(Password must be greater then 8 and less then 20)</label></td></tr>
	<tr><td><label for="addr">Enter your Address : </label></td><td><textarea name="addr" id="addr" required ></textarea></td></tr>
	<tr><td><label for="recmail">Enter recovery Id : </label></td><td><input type="email" name="recmail" id="recmail"  placeholder="Enter your recovery mail id"></td></tr>
	<tr><td>Tick the appropriate option(s) : </td>
	<tr><td></td><td><input type="checkbox" name="disease" id="disease"><label for="dis">Do you have any Transmission Disease?</label></td></tr>
	<tr><td></td><td><input type="checkbox" name="worked" id="worked" onclick="chk1()"><label for="worked">Have you ever worked in Blood bank?</label></td></tr>
	<tr id="tr1" style="visibility: hidden;"><td><label for="wname">Enter previous Work name : </label></td><td><input type="text" name="wname" id="wname"  placeholder="Previous Work name"></td></tr>
	<tr id="tr2" style="visibility: hidden;"><td><label for="wdesig">Enter previous Work designation : </label></td><td><input type="text" name="wdesig" id="wdesig"  placeholder="Designation"></td></tr>
	<tr id="tr3" style="visibility: hidden;"><td><label for="twexp">Enter total working experience(in years) : </label></td><td><input type="text" name="twexp" id="twexp"  placeholder="total working experience"></td></tr>
	<tr><td><button type="submit" name="sbt" id="sbt">Submit form</button></td><td><button type="reset" name="reset" id="reset">Cancel</button></td></tr>
</table>
</form>
</div>
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
<div class="fsz container-fluid sparrow footer" >
     <div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 20px">
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;<a href="https://www.facebook.com/"><i class="fa fa-facebook sz"></i></a>
                 <a href="https://www.twitter.com/"><i class="fa fa-twitter sz"></i></a>&nbsp;&nbsp;<a href="https://www.instagram.com/"><i class="fa fa-instagram sz"></i></a></p>
             <p>A2O BLOOD BANK SOLUTIONS : <a class="material-icons sz" href="../Index.html">home</a></p>
         </div>
     </div>
  </div>
</body>
</html>