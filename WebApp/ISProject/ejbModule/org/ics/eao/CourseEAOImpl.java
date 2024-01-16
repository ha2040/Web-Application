package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Course;
import org.ics.ejb.Exam;

/**
 * Session Bean implementation class CourseEAOImpl
 */
@Stateless
public class CourseEAOImpl implements CourseEAOLocal {
	@PersistenceContext(unitName = "KebabEJBSql")
	private EntityManager em;
  
	
    public CourseEAOImpl() {
        
    }

	public Course findByCourseId(String courseId) {
		
	return	em.find(Course.class, courseId);
	}
	
	public List<Course> findAllCourses() {
	    TypedQuery<Course> query = em.createNamedQuery("Course.findAllCourses", Course.class);
	    return query.getResultList();
	}

}
