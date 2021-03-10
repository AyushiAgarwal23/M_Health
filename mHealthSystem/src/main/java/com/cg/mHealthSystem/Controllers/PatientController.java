package com.cg.mHealthSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.services.PatientService;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/patient")
public class PatientController {
	
		@Autowired
		private PatientService patientService ;


//get all Doctors
		 @GetMapping("/getAllDoctors")
		    public List<Doctor> getAllDoctors(){
		        return (List<Doctor>) patientService.getAllDoctors();
		    }
		 
//get all Nurses
		 @GetMapping("/getAllNurse")
		    public List<Nurse> getAllNurse(){
		        return (List<Nurse>) patientService.getAllNurse();
		    }
		 
		 
//book by appointments
		 @PostMapping("/bookById")
		 	public Appointments bookById(@RequestBody Appointments appointment) {
			 	return patientService.bookbyId(appointment);
		 }


//View Appointments
		 @GetMapping("/ViewById/{appointmentId}")
		    public Appointments ViewById(@PathVariable Integer appointmentId){
		        return patientService.viewById(appointmentId);
		    }
		 
//Update

		    @PutMapping("/updateProfile/{gender:.+}/patientDetails/{patientId}")
		    public PatientDetails updateProfile(@PathVariable Integer patientId, @PathVariable String gender){
		        return patientService.updateProfile(patientId, gender);
		    }
//Get Patient details
			 @GetMapping("/retreivePatientRecordById/{recordId}")
			    public Appointments retreivePatientRecordById(@PathVariable Integer recordId){
			        return patientService.viewById(recordId);
			    }
		    
}
