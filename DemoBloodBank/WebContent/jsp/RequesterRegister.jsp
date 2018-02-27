<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*,com.dao.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requester Page</title>
<script type="text/javascript">
function onTick() {
	var chk = document.getElementById("cause").style.visibility = "visible";
}
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"><style type="text/css">
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
<h2>Blood Request Form page 1/2 :- </h2>
<%
Connection conn=DButil.getMyConnection();
%>
<div>
<form action="RequesterRegisterController" method="post" id="RequesterRegister_form1">

<h2 ><span style="color:'Brown'; border: 2px dotted #006400; border-radius: 10; background-color: #7CFC00;">Register Requester into System: </span></h2>
<table>
<tr><td><label for="fname">Enter First name : </label></td><td><input type="text" name="fname" id="fname" placeholder="First Name" required></td></tr>
<tr><td><label for="lname">Enter Last name : </label></td><td><input type="text" name="lname" id="lname" placeholder="Last Name" required></td></tr>
<tr><td>Select Gender : </td> 
								  <td><input type="radio" name="gender" value="Male"><label for="Male" > male</label>
								 	<input type="radio" value="Female" name="gender"><label for="Female" > Female</label></td></tr>
<tr><td><label for="weight">Enter your weight : </label></td><td><input type="text" name="weight" id="weight" placeholder="in KGs" required></td></tr>
<tr><td><label for="dob">Enter Date of Birth : </label></td><td><input type="date" name="dob" id="dob" min="01-01-1917" placeholder="YYYY-MM-DD" required></td></tr>
<tr><td><label for="btype">Select Blood Type : </label></td>
<td><select name="btype">

<% ResultSet rs=(ResultSet)request.getAttribute("resultset"); 
 while(rs.next()){%><option value="<%=rs.getString(2) %>"><%=rs.getString(2) %></option><%} %>
</select></td></tr>
<tr><td><label for="reqContact">Enter your Contact number : </label></td><td><input type="text" name="reqContact" id="reqContact"  value="+91-"></td></tr>
<tr><td><label for="email">Enter your email address : </label></td><td><input type="email" name="email" id="email"  placeholder="abc@gmail.com"></td></tr>
<tr><td><label for="addr">Enter your Address : </label></td><td><textarea name="addr" id="addr" required ></textarea></td></tr>
<tr><td><label for="hname">Enter Hospital name : </label></td><td><input type="text" name="hname" id="hname"  placeholder="Enter full hospital Name"></td></tr>
<tr><td><label for="dname">Enter Doctor name : </label></td><td><input type="text" name="dname" id="dname"  placeholder="Doctor Name"></td></tr>

<tr><td>Tick the appropriate option(s) : </td>

<tr><td></td><td><input type="checkbox" name="autologous" id="autologous"><label for="autologous">Are you a Autologous donor?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="disease" id="disease"><label for="dis">Do you have any Transmission Disease?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="donated" id="donated"><label for="received"> you ever donated blood?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="received" id="received"><label>Have you ever received blood?</label></td></tr>

<tr><td></td><td><input type="checkbox" name="accident" id="accident"><label for="accident">For Accidental case</label></td></tr>
<tr><td></td><td><input type="checkbox" name="transfusion" id="transfusion" onclick="onTick()"><label for="transfusion">For Transfusion case</label></td></tr>
<tr id="cause" style="visibility: hidden;"><td>Select type of transfusion: </td><td>
<select name="typeOfTransfusion">
<option value="Red BLood cell Transfusion" selected>Red BLood cell Transfusion</option>
<option value="Platelet Transfusion">Platelet Transfusion</option>
<option value="Plasma Transfusion">Plasma Transfusion</option>
<option value="Granulocytes">Granulocytes</option>
</select></td></tr>

<tr><td><button type="submit" name="sbt" id="sbt">Submit form</button></td><td><button type="reset" name="reset" id="reset">Cancel</button></td></tr>
</table>
</form>
</div>
<div class="fsz container-fluid sparrow footer" >
     <div class="row">
         <div class="col-xs-12 col-lg-12 col-md-12 col-sm-12 " style="padding-top: 5px">
                
             <p>&copy;2017 A2O BLOOD BANK SOLUTIONS, ALL RIGHTS RESERVED.</p>
             <p class="socialmediaicons">FOLLOW US OR LIKE US AT:&nbsp;
             	 <a href="https://www.facebook.com/"><i class="fa fa-facebook sz"></i></a>
                 <a href="https://www.twitter.com/"><i class="fa fa-twitter sz"></i></a>&nbsp;&nbsp;
                 <a href="https://www.instagram.com/"><i class="fa fa-instagram sz"></i></a></p>
             <p>A2O BLOOD BANK SOLUTIONS : <a class="material-icons sz" href="./Index.html">home</a></p>
         </div>
     </div>
  </div>
</body>
</html>