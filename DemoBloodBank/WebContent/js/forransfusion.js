/**
 * 
 */

function rbc(){
	window.alert("rbc running");
var div = document.getElementById("div1");
div.appendChild("<br>");

var opt = document.createElement("option");
var tr = document.createElement("tr");
var td = document.createElement("td");
var table = document.createElement("/table");

var text = document.createTextNode("Select reason : ");
	
	var select = document.createElement("select");
	select.setAtribute("name","reason");
	
	var t = "iron deficiency";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt1");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var t = "acute anaemia";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt2");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var t = "chronic anaemia";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt3");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var t = "surgery";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt4");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var t = "bone marrow transplantation";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt5");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var t = "neonates";
	opt.setAttribute("value",t);
	opt.setAttribute("id","opt6");
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	div.appendChild(text);
	div.appendChild(select);
	div.appendChild("<br>");
	
	document.getElementById("tdd").style.visibility="hidden";
}