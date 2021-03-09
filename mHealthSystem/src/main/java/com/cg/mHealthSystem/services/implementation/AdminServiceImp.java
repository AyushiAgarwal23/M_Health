package com.cg.mHealthSystem.services.implementation;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.services.AdminService;
@Service
@Transactional
public class AdminServiceImp implements AdminService {
	@Autowired
	private  DoctorRepository  ddao;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		
		
		return ddao.save(doctor);
	}

}
