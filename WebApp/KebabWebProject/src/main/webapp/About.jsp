<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/KebabWebProject/css/css.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
<script src="js/JavaScript.js"></script>
<meta charset="ISO-8859-1">
<title>Support/About</title>
</head>
<header>
	<div class="topNav">
		<nav>
			<img src="css/logo.PNG" alt="Website logo" id="webLogo">
			<ul>
				<li><a href="/KebabWebProject/MainServlet?action=Home">Home</a></li>
				<li><a href="#">Student</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addStudent">Add
								and view</a></li>
						<li><a
							href="/KebabWebProject/MainServlet?action=manageCourse">Add
								student to a course</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findStudent">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="#">Exam</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addExam">Add
								and view</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findExam">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="#">Result</a>
					<ul>
						<li><a href="/KebabWebProject/MainServlet?action=addResult">Add
								and view</a></li>
						<li><a href="/KebabWebProject/MainServlet?action=findResult">Search,
								update, and delete</a></li>
					</ul></li>
				<li><a href="/KebabWebProject/MainServlet?action=about">About/Support</a></li>
			</ul>
		</nav>
	</div>
</header>
<body>
	<a id="top"></a>
	<div class="contentBody">
		<h1>About Kebab Uni Manager:</h1>
		<div class="contentInput">
			<p style="margin-left: -386px;">
				<br> <br> <br> <br> Kebab Uni Manager is an
				online school managing system. <br>It allows the user to add
				students to the school system and also give them results on their
				exams. <br> <br>Kebab Uni Manager is currently in an early
				stage of its development and therefore lacks the feature to create
				new courses.
			</p>
			<img src="css/kebablogo.png" alt="skaneskebabtekniker logo"
				id="kebabteknikerlogo">
		</div>
		<div class="contentTable" style="margin-right: 50px;">
			<div class="formContainer">
				<form action="/KebabWebProject/MainServlet" method="post" id="myForm">
					<label for="email">Email</label> <input type="email" id="email"
						name="txtEmail" placeholder="YourMail@Email.com" required autocomplete="off">
					<label for="country">Subject category</label> <select
						id="issueRegarding" name="issueRegarding">
						<option value="report an issue">Report an issue</option>
						<option value="suggestion">Suggestion</option>
						<option value="error">Error</option>
						<option value="other">Other</option>
					</select> <label for="subject">Subject</label>
					<textarea id="subject" name="txtSubject"
						placeholder="Write something.." style="height: 200px" required></textarea>
					<input type="submit" value="Submit"> <input name="action"
						value="sendTicket" type="hidden">
				</form>
			</div>
		</div>
	</div>

	<a href="#top" id="goToTop"> <img src="css/arrow.png"
		alt="travel up link" style="width: 50px;">
	</a>
	<footer>
		<div class="footerContainer">
			<div class="row">
				<div class="col-md-6">
					<h3>About Us</h3>
					<p>We are a company that provides high-quality information
						systems.</p>
				</div>
				<div class="col-md-6">
					<h3>Contact Us</h3>
					<ul>
						<li>Email: skaneskebabtekniker@gmail.com</li>
						<li>Phone: 555-555-5555</li>
						<li>Address: 123 Main St, Anytown USA</li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>