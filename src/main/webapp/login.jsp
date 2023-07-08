<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<link rel="stylesheet" href="style.css">
</head>
<body id="body">

	<form method="post" action="login">
		<div id="loginform">
			<h1>Admin Login</h1>
			<label for="id"><b>User Id </b><span>*</span></label>
			<div>
				<input type="text" id="id" name="userId" required>
			</div>
			<br> <label for="password"><b>Password </b><span>*</span></label>
			<div>
				<input type="password" id="pass" name="password" required>
			</div>
			<br>
			<div>
				<center>
					<input type="submit" value="login"> <input type="reset"
						value="reset">
				</center>
			</div>
			<br>
			<%
			if (session.getAttribute("isWrongPassword")==null) {
			%>
			<br> <span style="margin-left: 33%; color: red;"><%="Wrong Credentials!!"%></span><br>
			<br>
			<%
			
			}
			%>

		</div>
	</form>

</body>
</html>