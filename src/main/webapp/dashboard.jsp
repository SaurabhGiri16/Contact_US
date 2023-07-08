<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.*, com.mountblue.saurabh.model.*, com.mountblue.saurabh.dao.*"%>

<html>
<head>
<title>Saved Information</title>
<style>
table, td {
	border: .1px solid;
	background-color: #c4eaec;
}

td {
	width: 10%;
}

body {
	padding-left: 5%;
	padding-right: 5%;
}

h1 {
	padding-left: 40%;
}

td:hover {
	background-color: hsl(215, 83%, 63%);
}

th, h1:hover {
	background-color: coral;
}
</style>
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	if (session.getAttribute("userId") == null) {
		response.sendRedirect("login");
		return;
	}
	%>
	<form action="login">
		<button>Logout</button>
	</form>
	<h1>Active Information</h1>
	<table>
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
			<th>Time</th>
			<th>Action</th>
		</tr>
		<%
		List<Request> activeRequests = (ArrayList<Request>)session.getAttribute("activeRequests");
		if (activeRequests != null) {
			for (Request activeRequest : activeRequests) {
		%>
		<tr>
			<td><%=activeRequest.getId()%></td>
			<td><%=activeRequest.getFullName()%></td>
			<td><%=activeRequest.getEmail()%></td>
			<td><%=activeRequest.getMessage()%></td>
			<td><%=activeRequest.getStatus()%></td>
			<td><%=activeRequest.getTimestamp()%></td>
			<td><form action="dashboard" method="post">
					<input type="hidden" name="user_id"
						value="<%=activeRequest.getId()%>"> <input type="hidden"
						name="status" value="<%=activeRequest.getStatus()%>"> <input
						type="submit" value="Archived">
				</form></td>
		</tr>
		<%
}
}
%>
		<tr>
	</table>
	<h1>Archived Information</h1>
	<table>
		<tr>
			<th>User Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Message</th>
			<th>Status</th>
			<th>Time</th>
			<th>Action</th>
		</tr>
		<%
		List<Request> archiveRequests = (ArrayList<Request>)session.getAttribute("archiveRequest");
		if (archiveRequests != null) {
			for (Request archiveRequest : archiveRequests) {
		%>
		<tr>
			<td><%=archiveRequest.getId()%></td>
			<td><%=archiveRequest.getFullName()%></td>
			<td><%=archiveRequest.getEmail()%></td>
			<td><%=archiveRequest.getMessage()%></td>
			<td><%=archiveRequest.getStatus()%></td>
			<td><%=archiveRequest.getTimestamp()%></td>
			<td><form action="dashboard" method="post">
					<input type="hidden" name="user_id"
						value="<%=archiveRequest.getId()%>"> <input type="hidden"
						name="status" value="<%=archiveRequest.getStatus()%>"> <input
						type="submit" value="Active">
				</form></td>
		</tr>
		<%
}
}
%>
		<tr>
	</table>
</body>
</html>