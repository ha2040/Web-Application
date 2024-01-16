<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	
</script>
<link rel="stylesheet" type="text/css" href="css/student.css">
<script src="js/student.js"></script>
<meta charset="ISO-8859-1">
<title>Student REST</title>
</head>
<body>
	<header>
		<p>Student RestClient demo</p>
	</header>
	<div id="wrap">
		<div id="wrapper">
			<section id="row">
				<div id="sideDiv">
					<div id="navContainer">
						<nav>
							<ul>
								<li class="active"><a>Student</a></li>
								<li><input type="button" name="submitBtn"
									value="Show students" id="ShowTable"></li>
								<li><input type="button" name="submitBtn"
									value="Hide students" id="HideStudents"></li>
							</ul>
						</nav>
						<aside>
							<table id="asideTable">
								<tr>
									<th><span id="city"></span></th>
									<th><span></span></th>
									<th><span></span></th>
									<th><span id="ipNbr"></span></th>
								</tr>
								<tr>
									<td><span id="degree"></span></td>
									<td><span id="weather"></span></td>
									<td><span></span></td>
									<td><span></span></td>
								</tr>
								<tr>
									<td colspan="4"><span id="sunrise"></span></td>
								</tr>
								<tr>
									<td colspan="4"><span id="sunset"></span></td>
								</tr>
							</table>
						</aside>
					</div>
				</div>
				<section id="main">
					<section id="content">
					<div id="inputContainer">
						<article>
							<fieldset id="PersonalFS">
								<legend>Student:</legend>
								<div id="inputContainer">
									Id:<br> <input type="text" name="id" id="id" value=""><br>
									Name:<br> <input type="text" name="name" id="name"
										value=""> <br> Address:<br> <input
										type="text" name="address" id="address" value="">
								</div>
								<div id="buttonContainer">
									<input type="button" name="submitBtn" value="Find" id="FindBtn">
									<input type="button" name="submitBtn" value="Add" id="AddBtn">
									<input type="button" name="submitBtn" value="Delete"
										id="DeleteBtn"> <input type="button" name="submitBtn"
										value="Update" id="UpdateBtn">
								</div>
							</fieldset>
							<label id="status"></label>
						</article>
						</div>
					</section>
				</section>
				<div id="tableDiv">
				<table id="studentsTable" class="styled-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<!-- Student data will be inserted here -->
					</tbody>
				</table>
				</div>
			</section>
		</div>
	</div>
	<footer>
		<p>&copy; Sk�nes Kebabtekniker</p>
	</footer>
</body>
</html>