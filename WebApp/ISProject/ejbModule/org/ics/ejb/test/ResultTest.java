package org.ics.ejb.test;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.ics.eao.ExamEAOImpl;
import org.ics.eao.ExamEAOLocal;
import org.ics.eao.ResultEAOImpl;
import org.ics.eao.StudentEAOImpl;
import org.ics.eao.StudentEAOLocal;
import org.ics.ejb.Course;
import org.ics.ejb.Exam;
import org.ics.ejb.ResultId;
import org.ics.ejb.Student;
import org.ics.ejb.Result;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultTest {
	
	private ResultId expectedResultId;	
	private int expectedPoints;
	private Student expectedStudent;
	private Exam expectedExam;
	private Result r1;
	private Course c1 = new Course("test", "test", "test", "test", 4);


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		Date date = new Date(1,1,1);
		
		expectedStudent = new Student("id", "name", "addy");
		expectedExam = new Exam("id", c1, "test", date, 5);
		expectedPoints = 50;
			r1 = new Result(expectedPoints, expectedStudent, expectedExam);
			
			
	}

	@AfterEach
	void tearDown() throws Exception {
		r1 = null;
	}

	@Test
	final void testGetPoints() {
		assertEquals(expectedPoints, r1.getPoints());
	}

	@Test
	final void testSetPoints() {
		int expectedPoints2 = 30;
		r1.setPoints(expectedPoints2);
		assertEquals(expectedPoints2, r1.getPoints());
	}

	@Test
	final void testGetStudent() {
		assertEquals(expectedStudent, r1.getStudent());
	}

	@Test
	final void testSetStudent() {
		Student expectedS2 = new Student("id2", "name", "addy");
		r1.setStudent(expectedS2);
		assertEquals(expectedS2, r1.getStudent());
	}

	@Test
	final void testGetExam() {
		assertEquals(expectedExam, r1.getExam());
	}

	@Test
	final void testSetExam() {
		Date date = new Date(1,1,1);
		Exam expectedE2 = new Exam("id2", c1, "test", date, 5);
		r1.setExam(expectedE2);
		assertEquals(expectedE2, r1.getExam());
	}

	@Test
	final void testGetExamId() {
		assertEquals(expectedExam.getExamId(), r1.getExamId(expectedExam));
	}

	@Test
	final void testGetStudentId() {
		assertEquals(expectedStudent.getStudentId(), r1.getStudentId(expectedStudent));
	}

}