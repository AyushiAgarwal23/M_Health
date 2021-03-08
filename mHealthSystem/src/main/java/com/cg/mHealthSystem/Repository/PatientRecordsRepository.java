package com.cg.mHealthSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mHealthSystem.entity.PatientRecords;

public interface PatientRecordsRepository  extends JpaRepository<PatientRecords,Integer> {

}
