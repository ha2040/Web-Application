
$(document).ready(function() {
	$('.styled-table th, .styled-table td').css('display', 'none'); // hide the table cells
	var statusLabel = document.getElementById("status");
			$.ajax({
				method: "GET",
				url: "http://api.ipstack.com/check?access_key=9d80f44a8effe264d40ef8e1ac2cb253",
				error: ajaxReturn_Error,
				success: ajaxReturn_Success
			})
			function ajaxReturn_Success(result, status, xhr) {
				ParseJsonFile(result);
			}
			function ajaxReturn_Error(result, status, xhr) {
				console.log("Ajax- student: " + status);
			} 
	$("#FindBtn").click(function() {
		var strValue = $("#id").val();
		console.log(strValue);
		if (strValue != "") {
			$.ajax({
				method: "GET",
				url: "http://localhost:8080/RestServerStudentProject/Students/" + strValue,
				error: ajaxFindReturnError,
				success: ajaxFindReturnSuccess
			})
			function ajaxFindReturnSuccess(result, status, xhr) {
				ParseJsonFileStudent(result);
				statusLabel.innerHTML = "Student found";
			}
			function ajaxFindReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-find student: " + status);
				statusLabel.innerHTML = "Student not found!";
			}
		}
		;
	})//btnclick

	$("#DeleteBtn").click(function() {
		var strValue = $("#id").val();
		if (strValue != "") {
			$.ajax({
				method: "DELETE",
				url: "http://localhost:8080/RestServerStudentProject/Students/" + strValue,
				error: ajaxDelReturnError,
				success: ajaxDelReturnSuccess
			})
			function ajaxDelReturnSuccess(result, status, xhr) {
				clearFields();
				loadStudentsTable();
				statusLabel.innerHTML = "Student: " + strValue + " deleted";
			}
			function ajaxDelReturnError(result, status, xhr) {
				alert("Error");
				console.log("Ajax-delete student: " + status);
			}
		}
	})//btnclick

	$("#AddBtn").click(function() {
		var strId = $("#id").val();
		var strName = $("#name").val();
		var strAddress = $("#address").val();
		var obj = { ID: strId, Name: strName, Address: strAddress };
		var jsonString = JSON.stringify(obj);
		if (strId != "") {
			$.ajax({
				method: "POST",
				url: "http://localhost:8080/RestServerStudentProject/Students/",
				data: jsonString,
				dataType: 'json',
				error: ajaxAddReturnError,
				success: ajaxAddReturnSuccess
			})
			function ajaxAddReturnSuccess(result, status, xhr) {
				clearFields();
				loadStudentsTable();
				statusLabel.innerHTML = "Student: " + strId + " added";
			}
			function ajaxAddReturnError(result, status, xhr) {
				alert("Error Add");
				console.log("Ajax-add student: " + status);
			}
		}
	})//btnclick
	$("#UpdateBtn").click(function() {
		var strId = $("#id").val();
		var strName = $("#name").val();
		var strAddress = $("#address").val();
		var obj = { ID: strId, Name: strName, Address: strAddress };
		var jsonString = JSON.stringify(obj);
		if (strId != "") {
			$.ajax({
				method: "PUT",
				url: "http://localhost:8080/RestServerStudentProject/Students/" + strId,
				data: jsonString,
				dataType: 'json',
				error: ajaxUpdateReturnError,
				success: ajaxUpdateReturnSuccess
			})
			function ajaxUpdateReturnSuccess(result, status, xhr) {
				clearFields();
				loadStudentsTable();
				statusLabel.innerHTML = "Student: " + strId + " updated";
			}
			function ajaxUpdateReturnError(result, status, xhr) {
				alert("Error Update");
				console.log("Ajax-update student: " + status);
			}
		}
	})//btnclick
	$("#ShowTable").click(function() {
		$('.styled-table th, .styled-table td').css('display', 'table-cell'); // show the table cells
		$("#studentsTable").show();
		loadStudentsTable();
	})//btnclick
	$("#HideStudents").click(function() { $("#studentsTable").hide(); });
});//End ready function

function ParseJsonFileStudent(result) {
	$("#id").val(result.ID);
	$("#name").val(result.Name);
	$("#address").val(result.Address);
}
function clearFields() {
	$("#id").val("");
	$("#name").val("");
	$("#address").val("");
}
function loadStudentsTable() {
	$.ajax({
		method: "GET",
		url: "http://localhost:8080/RestServerStudentProject/Students",
		dataType: 'json',
		error: function(result, status, xhr) {
			console.log("Ajax-load students table: " + status);
		},
		success: function(result, status, xhr) {
			var tableBody = $("#studentsTable tbody");
			tableBody.empty(); // Clear table body

			// Show the <thead> of the table
			$("#studentsTable thead").removeClass("hide");

			$.each(result, function(index, student) {
				var row = $("<tr>");
				row.append($("<td>").text(student.id));
				row.append($("<td>").text(student.name));
				row.append($("<td>").text(student.address));
				tableBody.append(row);
			});
		}
	});
}

function ParseJsonFile(result) {
	var lat = result.latitude;
	var long = result.longitude;
	var city = result.city;
	var ipNbr = result.ip
	$("#city").text(city);
	$("#ipNbr").text(ipNbr);
	$.ajax({
		method: "GET",
		url: "http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" +
			long + "&units=metric" + "&APPID=d7a86cd9e0151729f55b8d1be171b0ef",
		error: ajaxWeatherReturn_Error,
		success: ajaxWeatherReturn_Success
	})
	function ajaxWeatherReturn_Success(result, status, xhr) {
		var sunrise = result.sys.sunrise;
		var sunset = result.sys.sunset;
		var sunriseDate = new Date(sunrise * 1000);
		var timeStrSunrise = sunriseDate.toLocaleTimeString();
		var sunsetDate = new Date(sunset * 1000);
		var timeStrSunset = sunsetDate.toLocaleTimeString();
		$("#sunrise").text("Sunrise: " + timeStrSunrise);
		$("#sunset").text("Sunset: " + timeStrSunset);
		$("#weather").text(result.weather[0].main);
		$("#degree").text(result.main.temp + " \u2103");
	}//ajaxWeatherReturn_Success
	function ajaxWeatherReturn_Error(result, status, xhr) {
		alert("Error i OpenWeaterMap Ajax");
		console.log("Ajax-find movie: " + status);
	}
}
