
package com.cg.mHealthSystem.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mHealthSystem.Exception.ResourceNotFoundException;
import com.cg.mHealthSystem.Repository.AppointmentsRepository;
import com.cg.mHealthSystem.Repository.DoctorRepository;
import com.cg.mHealthSystem.Repository.PatientRecordsRepository;
import com.cg.mHealthSystem.entity.Appointments;
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.DoctorService;




@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService ;
	
	@Autowired
	private AppointmentsRepository appDao;
	
	@Autowired
	private DoctorRepository doctDao;
	
	@Autowired
	private PatientRecordsRepository patrecDao;
	
	
	
	private static final Logger logger=LoggerFactory.getLogger(PatientController.class);
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor )
	{
		logger.info("In Doctor controller, add doctors method");
		return doctorService.addDoctor(doctor);
	}
	
	
	 @PutMapping("/updateProfile/{deptId:.+}/patientDetails/{doctorId}")
	 public Doctor updateProfile(@PathVariable Integer doctorId, @PathVariable Department department )
	 {
		 logger.info("In Doctor controller, Update Profile method");
		 Optional<Doctor> doctor = doctDao.findById(doctorId);
		 if(doctor.isPresent())
		 {
	        return doctorService.updateProfile(doctorId, department);
		 }
		 else
		 {
			 throw new ResourceNotFoundException();
		 }
	 }
	 
	 
	 
	 
	 @GetMapping("/viewAppointment/{appointmentId}")
	    public Appointments viewAppointment(@PathVariable Integer appointmentId)
	    {
		 logger.info("In Doctor controller, viewAppointment method");
		 
		 Optional<Appointments> appointment = appDao.findById(appointmentId);
		 if(appointment.isPresent())
		 {
	        return doctorService.viewAppointment(appointmentId);
		 }
		 else
		 {
			 throw new ResourceNotFoundException();
		 }
	    }
	 
	 
	 
	 
	 
	 @GetMapping("/patientRecord/{patientId}")
	    public PatientRecords patientRecord(@PathVariable Integer patientId)
	    {
		 logger.info("In Doctor controller, patientRecord method");
		 Optional<PatientRecords> patientrecords = patrecDao.findById(patientId);
		 if(patientrecords.isPresent())
		 
		 {
			 return doctorService.patientRecord(patientId);
		 }
		 else
		 {
			 throw new ResourceNotFoundException();
		 }
		 
		 }
	    

}

