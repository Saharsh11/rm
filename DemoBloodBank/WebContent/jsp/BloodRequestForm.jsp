<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*,com.dao.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Showing Blood Compatibility </title>
<script type="text/javascript" src="./js/BloodRequestForm.js"></script>
</head>
<body>
<h2>Blood Request Form page 2/2 :- </h2>
<form method="post" >
<table style="border: 2px solid black;">
<tr><td>Select reason for Requesting Blood :</td>
<td><input type="radio" id="reason1" name="reason" value="Accident" onclick="chk()"><label for="reason1">For Accidental Cause</label></td>
<td><input type="radio" id="reason2" name="reason" value="Transfusion" onclick=""><label for="reason2">For Blood Transfusion</label></td></tr>
</table>
<br>
<%@include file="forAccident.jsp" %>
<div id="td3"></div>
</form>
</body>
</html>