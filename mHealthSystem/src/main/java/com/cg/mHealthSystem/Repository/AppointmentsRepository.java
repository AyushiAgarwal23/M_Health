package com.cg.mHealthSystem.Repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.mHealthSystem.entity.Appointments;

/**
 * 
 * @author ayushranjan
 *
 *Appointment Repository interface which extends CrudRepository 
 */
public interface AppointmentsRepository  extends CrudRepository<Appointments,Integer> {

}
