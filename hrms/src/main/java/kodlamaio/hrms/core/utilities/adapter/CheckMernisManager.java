package kodlamaio.hrms.core.utilities.adapter;

import kodlamaio.hrms.entities.concretes.Candidate;

public class CheckMernisManager implements CheckMernisService{

	@Override
	public boolean CheckIfRealPerson
	(Candidate candidate) {
		return true;
	}

	
}
