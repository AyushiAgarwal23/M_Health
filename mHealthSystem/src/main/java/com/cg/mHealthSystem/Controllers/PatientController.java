package com.cg.mHealthSystem.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.Logger.logger;
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
		
private static final Logger logger=LoggerFactory.getLogger(PatientController.class);

//get all Doctors
		 @GetMapping("/getAllDoctors")
		    public List<Doctor> getAllDoctors(){
			 logger.info("In Patient controller, get all doctors method");
		        return (List<Doctor>) patientService.getAllDoctors();
		    }
		 
//get all Nurses
		 @GetMapping("/getAllNurse")
		    public List<Nurse> getAllNurse(){
			 logger.info("In Patient controller, get all nurses method");
		        return (List<Nurse>) patientService.getAllNurse();
		    }
		 
		 
//book by appointments
		 @PostMapping("/bookById")
		 	public Appointments bookById(@RequestBody Appointments appointment) {
			 logger.info("In controller, bookById method");
			 	return patientService.bookbyId(appointment);
		 }


//View Appointments
		 @GetMapping("/ViewById/{appointmentId}")
		    public Appointments ViewById(@PathVariable Integer appointmentId){
			 logger.info("In Patient controller, ViewById method");
		        return patientService.viewById(appointmentId);
		    }
		 
//Update

		    @PutMapping("/updateProfile/{dateOfBirth:.+}/patientDetails/{patientId}")
		    public PatientDetails updateProfile(@PathVariable Integer patientId, @PathVariable String dateOfBirth){
		    	logger.info("In Patient controller, get all updateProfile method");
		        return patientService.updateProfile(patientId, dateOfBirth);
		    }
//Get Patient details
			 @GetMapping("/retreivePatientRecordById/{recordId}")
			    public Appointments retreivePatientRecordById(@PathVariable Integer recordId){
				 logger.info("In Patient controller, retreivePatientRecordById method");
			        return patientService.viewById(recordId);
			    }
		    
}
