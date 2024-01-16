package org.ics.eao;

import java.util.List;
import java.util.Random;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Exam;

/**
 * Session Bean implementation class ExamEAOImpl
 */
@Stateless
public class ExamEAOImpl implements ExamEAOLocal {
	@PersistenceContext(unitName = "KebabEJBSql")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ExamEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public Exam findByExamId(String id) {
		return em.find(Exam.class, id);
	}

	public Exam createExam(Exam exam) {
		em.persist(exam);
		return exam;
	}

	public Exam updateExam(Exam exam) {
		em.merge(exam);
		return exam;
	}

	public void deleteExam(String id) {
		Exam e = this.findByExamId(id);
		if (e != null) {
			em.remove(e);
		}
	}

	public List<Exam> findAllExams() {
		TypedQuery<Exam> query = em.createNamedQuery("Exam.findAllExams", Exam.class);
		return query.getResultList();
	}

	public String generateId() {
		Random rand = new Random();
		int randomNum = rand.nextInt(9000);
		String id = "EX" + randomNum;
		return id;
	}

	public List<Exam> findExamsByStudentId(String studentId) {
		TypedQuery<Exam> query = em.createNamedQuery("Exam.findExamsByStudentId", Exam.class);
		query.setParameter("studentId", studentId);
		List<Exam> exams = query.getResultList();
		return exams;
	}
}
