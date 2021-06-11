package com.nberimen.candidate;

import java.util.List;

import com.nberimen.resume.Resume;
import com.nberimen.utilities.result.DataResult;
import com.nberimen.utilities.result.Result;

public interface CandidateService {

	public DataResult<List<Candidate>> getAll();
	public Result register(Candidate candidate);
	public Result saveResume(Resume resume, int candidateId);
	public DataResult<Candidate> getById(int id);
}
