package com.cg.mHealthSystem.services;

import com.cg.mHealthSystem.entity.Appointments;

public interface AppointmentService {
	Appointments findAppointmentById(Integer appointmentId);
	Iterable<Appointments> getaAllAppointments();
	Appointments createAppointments(Appointments appointment);
	boolean deleteAppointmentsById(Integer appointmentId);
}
