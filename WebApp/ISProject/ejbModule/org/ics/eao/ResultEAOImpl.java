package org.ics.eao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.ics.ejb.Exam;
import org.ics.ejb.Result;
import org.ics.ejb.ResultId;

@Stateless
public class ResultEAOImpl implements ResultEAOLocal {

	@PersistenceContext(unitName = "KebabEJBSql")
	private EntityManager em;

	public ResultEAOImpl() {
	}

	public Result findResult(String studentId, String examId) {
		ResultId id = new ResultId(studentId, examId);
		return em.find(Result.class, id);
	}

	public Result createResult(Result result) {
		em.persist(result);
		return result;
	}

	public Result updateResult(Result result) {
		return em.merge(result);
	}

	public List<Result> findAllResult() {
		TypedQuery<Result> query = em.createNamedQuery("Result.findAllResults", Result.class);
		return query.getResultList();
	}

	public List<Result> findAllResultsByStudentId(String id) {
		TypedQuery<Result> query = em.createNamedQuery("Result.findAllResultsByStudentId", Result.class);
		query.setParameter("studentId", id);
		return query.getResultList();
	}

	public void deleteResult(String studentId, String examId) {
		Result r = this.findResult(studentId, examId);
		if (r != null) {
			em.remove(r);
		}
	}

	public Result findResult(ResultId resultId) {
		return em.find(Result.class, resultId);
	}
}
