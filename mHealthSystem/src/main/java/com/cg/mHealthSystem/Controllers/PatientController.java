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

import com.cg.mHealthSystem.Exception.ResourceNotFoundException;
import com.cg.mHealthSystem.Logger.logger;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.PatientDetailsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.Nurse;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.PatientService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



@RestController
@RequestMapping("/patient")
public class PatientController {
	
		@Autowired
		private PatientService patientService ;
		@Autowired
		DoctorRepository doctorDao;
		@Autowired
		PatientDetailsRepository patientDao;
		
private static final Logger logger=LoggerFactory.getLogger(PatientController.class);

/*get all Doctors*/
		 @GetMapping("/getAllDoctors")
		    public List<Doctor> getAllDoctors(){
			 logger.info("In Patient controller, get all doctors method");
			 Iterable<Doctor> n1= patientService.getAllDoctors();
			 List<Doctor> result = StreamSupport.stream(n1.spliterator(), false).collect(Collectors.toList());
			 if(result.isEmpty()) {
				 throw new ResourceNotFoundException("No data Found");
			 }
			
		        return (List<Doctor>) patientService.getAllDoctors();
		    }
		 
/*get all Nurses*/
		 @GetMapping("/getAllNurse")
		    public List<Nurse> getAllNurse(){
			 logger.info("In Patient controller, get all nurses method");
			 Iterable<Nurse> n1= patientService.getAllNurse();
			 List<Nurse> result = StreamSupport.stream(n1.spliterator(), false).collect(Collectors.toList());
			 if(result.isEmpty()) {
				 throw new ResourceNotFoundException("No data Found");
			 }
			
		        return (List<Nurse>) patientService.getAllNurse();
		    }
		 
		 
/*Insert patient id*/
		 @PostMapping("/insert")
		 public PatientDetails insert(@RequestBody PatientDetails patientDetails) {
			 logger.info("In controller, insert method");
			 return patientService.insert(patientDetails);
		 }
		 
/*book by appointments*/
		 @PostMapping("/bookById/{patientId}")
		 	public Appointments bookById(@PathVariable Integer patientId, @RequestBody Appointments appointment) {
			 logger.info("In controller, bookById method");
			 
			 Integer ID= appointment.getDoctorId();
			 Optional<Doctor> doctor= doctorDao.findById(ID);
			 if(doctor.isPresent()) {
				 throw new ResourceNotFoundException("Doctor Not found");
			 }
			 Doctor doctor1= doctor.get();
			 Appointments appointment1= doctor1.getAppointments();
			 if(appointment1==null) {
				 doctor1.setAppointments(appointment);
				 
				 return patientService.bookbyId(patientId, appointment);
			 }
			 if(appointment1.getStartTime().equalsIgnoreCase(appointment.getStartTime())) {
				 throw new ResourceNotFoundException("Time mismatch");
			 }
			 
			 	return patientService.bookbyId(patientId, appointment);
		 }


/*View Appointments by Patient ID*/
		 
		 @GetMapping("/ViewById/{patientId}")
		    public Appointments ViewById(@PathVariable Integer patientId){
			 logger.info("In Patient controller, ViewById method");
			 if(patientDao.findById(patientId).isPresent()) {
				 throw new ResourceNotFoundException("Appointment Not Found");
			 }
			 return patientService.viewById(patientId);
		    }
		 
/*Update*/

		    @PutMapping("/updateProfile/patientDetails/{patientId}")
		    public PatientDetails updateProfile(@PathVariable Integer patientId, @RequestBody PatientDetails patientDetails){
		    	logger.info("In Patient controller, get all updateProfile method");
		    	patientDetails.setPatientId(patientId);
		    	 if(patientDao.findById(patientId).isPresent()) {
					 throw new ResourceNotFoundException("Patient Not Found");
		    	 }
		    	return patientService.updateProfile(patientDetails);
		    	
		    }

		    
		    
/*Get Patient details*/
		  
		   @GetMapping("/retreivePatientRecordById/{patientId}")
			    public PatientRecords retreivePatientRecordById(@PathVariable Integer patientId){
				 logger.info("In Patient controller, retreivePatientRecordById method");
				 if(patientDao.findById(patientId).isPresent()) {
					 throw new ResourceNotFoundException("Patient not Found");
		    	 }
			        return patientService.retreivePatientRecordById(patientId);
			        	
			        		
			    }
		    
}
