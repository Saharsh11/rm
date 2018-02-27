/**
 * 
 */

function chk(){
	
	
	var field = document.getElementById("td3");
	var mybr = document.createElement("<br>");
	var rad = document.createElement("radio");
	
	var text = document.createTextNode("Enter Unique Identification number: ");
	var ip = document.createElement("input");
	ip.setAttribute("type","text");
	ip.setAttribute("name","uid");
	ip.setAttribute("id","uid");
	ip.setAttribute("placeholder","Enter uid number");
	field.appendChild(text);
	field.appendChild(ip);
	field.appendChild(mybr);
	
	
	
	var text = document.createTextNode("emergency room No : ");
	
	var ip = document.createElement("input");
	ip.setAttribute("type","text");
	ip.setAttribute("name","rno");
	ip.setAttribute("id","rno");
	ip.setAttribute("placeholder","Enter room no.");
	field.appendChild(text);
	field.appendChild(ip);
	field.appendChild(mybr);
	field.appendChild(mybr);
	
	var text = document.createTextNode("Amount of blood required : ");
	var select = document.createElement("select");
	
	var opt = document.createElement("option");
	opt.setAttribute("value","4000");
	var t="4000 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var opt = document.createElement("option");
	opt.setAttribute("value","3000");
	var t="3000 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var opt = document.createElement("option");
	opt.setAttribute("value","2000");
	var t="2000 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var opt = document.createElement("option");
	opt.setAttribute("value","1000");
	var t="1000 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var opt = document.createElement("option");
	opt.setAttribute("value","500");
	var t="500 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);
	
	var opt = document.createElement("option");
	opt.setAttribute("value","250");
	var t="250 ml";
	opt.appendChild(document.createTextNode(t));
	select.appendChild(opt);

	field.appendChild(mybr);field.appendChild(mybr);
	field.appendChild(text);
	field.appendChild(select);
	
	field.appendChild(mybr);
	
	var text = document.createTextNode("Enter Number of bottles required : ");
	
	var ip = document.createElement("input");
	ip.setAttribute("type","text");
	ip.setAttribute("name","bottleNo");
	ip.setAttribute("id","bottleNo");
	ip.setAttribute("placeholder","number of bottles");
	field.appendChild(text);
	field.appendChild(ip);
	
}

function chk1(){
}