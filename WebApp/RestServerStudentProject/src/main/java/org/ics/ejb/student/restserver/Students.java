package org.ics.ejb.student.restserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ics.ejb.Student;
import org.ics.facade.FacadeLocal;

/**
 * Servlet implementation class Students
 */
@WebServlet("/Students/*")
public class Students extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FacadeLocal facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			System.out.println("Alla");
			System.out.println(pathInfo);
			List<org.ics.ejb.Student> allStudents = facade.findAllStudents();
			sendAsJson(response, allStudents);
			return;
		}
		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			System.out.println("Alla2");
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		Student student = facade.findByStudentId(id);
		sendAsJson(response, student);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			BufferedReader reader = request.getReader();// Läs data Json
			Student s = parseJsonStudent(reader);
			try {
				s = facade.createStudent(s);
			} catch (Exception e) {
				System.out.println("duplicate key");
			}
			sendAsJson(response, s);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		BufferedReader reader = request.getReader();
		Student s = parseJsonStudent(reader);
		// Uppdatera i db
		try {
			s = facade.updateStudent(s);
		} catch (Exception e) {
			System.out.println("facade Update Error");
		}
		sendAsJson(response, s);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (pathInfo == null || pathInfo.equals("/")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String[] splits = pathInfo.split("/");
		if (splits.length != 2) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		String id = splits[1];
		Student student = facade.findByStudentId(id);
		if (student != null) {
			facade.deleteStudent(id);
		}
		sendAsJson(response, student);
	}

	private void sendAsJson(HttpServletResponse response, Student student) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (student != null) {
			out.print("{\"ID\":");
			out.print("\"" + student.getStudentId() + "\"");
			out.print(",\"Name\":");
			out.print("\"" + student.getStudentName() + "\"");
			out.print(",\"Address\":");
			out.print("\"" + student.getAddress() + "\"}");
		} else {
			out.print("{ }");
		}
		out.flush();
	}

	private void sendAsJson(HttpServletResponse response, List<Student> students) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		if (students != null) {
			JsonArrayBuilder array = Json.createArrayBuilder();
			for (org.ics.ejb.Student s : students) {
				JsonObjectBuilder o = Json.createObjectBuilder();
				o.add("id", s.getStudentId());
				o.add("name", s.getStudentName());
				o.add("address", s.getAddress());
				array.add(o);
			}
			JsonArray jsonArray = array.build();
			System.out.println("Student rest: " + jsonArray);
			out.print(jsonArray);
		} else {
			out.print("[]");
		}
		out.flush();
	}

	private Student parseJsonStudent(BufferedReader br) {
		// javax.json-1.0.4.jar
		JsonReader jsonReader = null;
		JsonObject jsonRoot = null;
		jsonReader = Json.createReader(br);
		jsonRoot = jsonReader.readObject();
		System.out.println("JsonRoot: " + jsonRoot);
		Student student = new Student();
		student.setStudentId(jsonRoot.getString("ID"));
		student.setStudentName(jsonRoot.getString("Name"));
		student.setAddress(jsonRoot.getString("Address"));
		return student;
	}

}
