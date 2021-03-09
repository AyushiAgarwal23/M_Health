package com.cg.mHealthSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Appointments;

public interface AppointmentsRepository  extends CrudRepository<Appointments,Integer> {

}
