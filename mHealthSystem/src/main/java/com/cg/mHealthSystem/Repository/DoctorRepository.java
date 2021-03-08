package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mHealthSystem.entity.Doctor;



public interface DoctorRepository  extends JpaRepository< Doctor,Integer > {

}
