package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mHealthSystem.Controllers.PatientController;
import com.cg.mHealthSystem.Repository.NurseRepository;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.NurseService;

@Service
@Transactional 

public class NurseServiceImp implements NurseService {
	
	@Autowired
	private NurseRepository nurseDao;
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);
	@Override
	public Nurse addNurse(Nurse nurse)
	{
		logger.info("In Nurse Service, add nurse method");
		return nurseDao.save(nurse);
	}
	@Override
	public Nurse updateNurse(Integer nurseFee, Integer nurseId) 
	{
		 Nurse nurse1 = nurseDao.findById(nurseId).get();
	        nurse1.setNurseFee(nurseFee);
	        logger.info("In Nurse Service, update nurse method");
	        return nurseDao.save(nurse1);
	}

}
