package com.cg.mHealthSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminservice ;
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor )
	{
		return adminservice.addDoctor(doctor);
	}
	

}
