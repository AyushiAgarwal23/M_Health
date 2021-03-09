package com.cg.mHealthSystem.services;

import com.cg.mHealthSystem.entity.Nurse;

public interface NurseService {
	
	Nurse addNurse(Nurse nurse);
	Nurse updateNurse(Integer nurseFee,Integer nurseId);

}
