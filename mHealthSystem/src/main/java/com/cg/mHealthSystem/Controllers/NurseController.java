package com.cg.mHealthSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.NurseService;

@RestController
@RequestMapping("/nurse")
public class NurseController{
	@Autowired
	private NurseService nurseservice;
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);
	@PostMapping("/addNurse")
	public Nurse addNurse(@RequestBody Nurse nurse)
	{
		logger.info("In Nurse controller, add Nurse method");
		return nurseservice.addNurse(nurse);
	}
	@PutMapping("/updateNurse/{nurseFee:.+}/Nurse/{nurseId}")
    public Nurse updateNurse(@PathVariable Integer nurseFee,@PathVariable Integer nurseId)
	{
		logger.info("In Nurse controller,Update Nurse method");
        return nurseservice.updateNurse(nurseFee,nurseId);
    }

}