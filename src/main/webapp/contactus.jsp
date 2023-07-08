
<!DOCTYPE html>
<html>
<head>

<title>Contact Us</title>
<link rel="stylesheet" href="style.css">
</head>

<body id="body">
	<form id="form" method="post" action="contactus">
		<div id="heading">

			<h1>Contact Us</h1>
			<p>Please fill this form in a decent manner</p>
		</div>

		<div id="contactusform">
			<br> <label for="name"><b>Full Name <span>*</span></b></label>
			<div>
				<input type="text" id="name" name="name" required>
			</div>

			<label for="email"><b>E-mail <span>*</span></b></label>
			<div>
				<input type="email" id="email" name="email" required>
				<p id="minimize_paragraph">example@example.com</p>
			</div>

			<label for="message"><b>Message <span>*</span></b></label>
			<div>
				<textarea type="message" id="message" name="message" rows="5"
					required></textarea>
			</div>

			<center>
				<input type="submit" value="submit">
			</center>
		</div>
		<%
			if (session.getAttribute("Submitted")== null) {
			%>
			<br> <span style="margin-left: 33%; color: green;"><%="Submitted Successfully..."%></span><br>
			<br>
			<%
			
			}
			%>
	</form>

</body>
</html>