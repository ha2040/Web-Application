package org.ics.ejb.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.ics.eao.CourseEAOImpl;
import org.ics.eao.CourseEAOLocal;
import org.ics.ejb.Course;
import org.ics.ejb.Exam;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExamTest {
	
	private String expectedExamId;
	private Course expectedCourse;
	private String expectedRoom;
	private Date expectedExamDate;
	private int expectedCredit;
	private Date expectedExamDate2;
	private Exam e1;
	private Exam e2;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() throws Exception {
		expectedExamId = "EX020";
		expectedCourse = new Course("test", "test", "test", "test", 4);
		expectedRoom = "E-hus";
		expectedExamDate = new Date(1, 1, 2023);
		expectedCredit = 4;
		
			e1 = new Exam(expectedExamId, expectedCourse, expectedRoom, expectedExamDate, expectedCredit);
	}

	@AfterEach
	void tearDown() throws Exception {
		e1 = null;
		e2 = null;
	}

	@Test
	final void testGetExamId() {
		assertEquals(expectedExamId, e1.getExamId());
	}

	@Test
	final void testSetExamId() {
		String expectedExamId2 = "EX350";
		e1.setExamId(expectedExamId2);
		assertEquals(expectedExamId2, e1.getExamId());
	}

	@Test
	final void testGetCourse() {
		assertEquals(expectedCourse, e1.getCourse());
	}

	@Test
	final void testSetCourse() {
		Course expectedC2 = new Course("test5", "test", "test", "test", 4);
		e1.setCourse(expectedC2);
		assertEquals(expectedC2, e1.getCourse());
	}

	@Test
	final void testGetRoom() {
		assertEquals(expectedRoom, e1.getRoom());
	}

	@Test
	final void testSetRoom() {
		String expectedRoom2 = "Test";
		e1.setRoom(expectedRoom2);
		assertEquals(expectedRoom2, e1.getRoom());
	}

	@Test
	final void testGetExamDate() {
		assertEquals(expectedExamDate, e1.getExamDate());
	}

	@SuppressWarnings("deprecation")
	@Test
	final void testSetExamDate() {
		Date expectedExamDate2 = new Date(1,1,1);
		e1.setExamDate(expectedExamDate2);
		assertEquals(expectedExamDate2, e1.getExamDate());
	}

	@Test
	final void testGetCredit() {
		assertEquals(expectedCredit, e1.getCredit());
	}

	@Test
	final void testSetCredit() {
		int expectedCredit2 = 30;
		e1.setCredit(expectedCredit2);
		assertEquals(expectedCredit2, e1.getCredit());
	}

}
