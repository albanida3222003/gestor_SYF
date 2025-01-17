<%@page import="java.util.List"%>
<%@page import="com.unu.beans.Productos"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file ="/cabecera.jsp"%>
	<%
	List<Productos> productos = (List<Productos>) request.getAttribute("productos");
	%>

	<table id="tabla" class="table table-bordered" border = 3>
		<thead>
			<tr>
				<th>Color</th>
			</tr>
		</thead>
		<tbody>
			<%
			if (productos != null) {
				for (Productos pro : productos) {
					
			%>
			<tr>
				<td><%=pro.getColor()%></td>
			</tr>
			<%
			}
			}
			%>
		</tbody>
</body>
</html>