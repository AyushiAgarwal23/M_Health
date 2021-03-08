package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mHealthSystem.entity.Appointments;

public interface AppointmentsRepository  extends JpaRepository<Appointments,Integer> {

}
