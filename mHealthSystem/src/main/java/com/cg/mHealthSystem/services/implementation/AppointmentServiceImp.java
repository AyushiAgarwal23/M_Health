package com.cg.mHealthSystem.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.services.AppointmentService;

@Service
public class AppointmentServiceImp implements  AppointmentService{
	@Autowired
	private AppointmentsRepository adao;

	@Override
	public Appointments findAppointmentById(Integer appointmentId) {

		return adao.findById(appointmentId).get(); 
	}

	@Override
	public Iterable<Appointments> getaAllAppointments() {

		return adao.findAll();
	}

	@Override
	public Appointments createAppointments(Appointments appointment) {

		return adao.save(appointment);
	}

	@Override
	public boolean deleteAppointmentsById(Integer appointmentId) {

		adao.deleteById(appointmentId);
		Appointments appointment = adao.findById(appointmentId).get();
		return false;
	}

}
