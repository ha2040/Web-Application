package org.ics.eao;

import java.util.List;

import javax.ejb.Local;

import org.ics.ejb.Exam;
import org.ics.ejb.Result;
import org.ics.ejb.ResultId;

@Local
public interface ResultEAOLocal {

	public Result findResult(String studentId, String examId);

	public Result createResult(Result result);

	public Result updateResult(Result result);

	public List<Result> findAllResult();

	public List<Result> findAllResultsByStudentId(String id);

	public void deleteResult(String studentId, String examId);
	
	public Result findResult(ResultId resultId);
}