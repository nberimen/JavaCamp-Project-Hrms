package com.nberimen.candidate;

import java.util.List;

import com.nberimen.core.utilities.DataResult;
import com.nberimen.core.utilities.Result;

public interface CandidateService {

	public DataResult<List<Candidate>> getAll();
	public Result register(Candidate candidate);
}
