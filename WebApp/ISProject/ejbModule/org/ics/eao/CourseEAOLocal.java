package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Course;

@Local
public interface CourseEAOLocal {
	Course findByCourseId(String courseId);
	 List<Course> findAllCourses();
}
