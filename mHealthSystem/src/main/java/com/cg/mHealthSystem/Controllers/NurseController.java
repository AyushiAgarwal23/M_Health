package com.cg.mHealthSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.services.NurseService;

@RestController
@RequestMapping("/nurse")
public class NurseController {
	@Autowired
	private NurseService nurseservice;
	@PostMapping("/addNurse")
	public Nurse addNurse(@RequestBody Nurse nurse)
	{
		return nurseservice.addNurse(nurse);
	}
	@PutMapping("/updateNurse/{nurseFee:.+}/Nurse/{nurseId}")
    public Nurse updateNurse(@PathVariable Integer nurseFee,@PathVariable Integer nurseId)
	{
        return nurseservice.updateNurse(nurseFee,nurseId);
    }

}
