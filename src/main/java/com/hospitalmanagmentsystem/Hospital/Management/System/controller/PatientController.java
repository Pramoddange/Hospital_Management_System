package com.hospitalmanagmentsystem.Hospital.Management.System.controller;

import com.hospitalmanagmentsystem.Hospital.Management.System.models.Hospital;
import com.hospitalmanagmentsystem.Hospital.Management.System.models.Patient;
import com.hospitalmanagmentsystem.Hospital.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Patient")

public class PatientController {
    @Autowired
    PatientService patientService;
    public String registerPatient(@RequestBody Patient obj){
        patientService.register(obj);
        return "Patient got register successfully";
    }
   // @GetMapping
    //public Patient getByPatientId(){

    //}
}
