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
import com.cg.mHealthSystem.entity.Department;
import com.cg.mHealthSystem.entity.Doctor;
import com.cg.mHealthSystem.entity.PatientDetails;
import com.cg.mHealthSystem.entity.PatientRecords;
import com.cg.mHealthSystem.services.DoctorService;



@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService ;
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor )
	{
		return doctorService.addDoctor(doctor);
	}
	 @PutMapping("/updateProfile/{deptId:.+}/patientDetails/{doctorId}")
	 public Doctor updateProfile(@PathVariable Integer doctorId, @PathVariable Department department )
	 {
	        return doctorService.updateProfile(doctorId, department);
	 }
	 @GetMapping("/viewAppointment/{appointmentId}")
	    public Appointments viewAppointment(@PathVariable Integer appointmentId)
	    {
	        return doctorService.viewAppointment(appointmentId);
	    }
	 @GetMapping("/patientRecord/{patientId}")
	    public PatientRecords patientRecord(@PathVariable Integer patientId)
	    {
	        return doctorService.patientRecord(patientId);
	    }

}
