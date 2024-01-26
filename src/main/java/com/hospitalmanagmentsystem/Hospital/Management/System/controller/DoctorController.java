package com.hospitalmanagmentsystem.Hospital.Management.System.controller;


import com.hospitalmanagmentsystem.Hospital.Management.System.models.Doctor;
import com.hospitalmanagmentsystem.Hospital.Management.System.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http:localhost:8080/hospital -> Hospital Controller
//http:localhost:8080/doctor/register -> Doctor Controller
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/register")
    public String register(@RequestBody Doctor obj){
        doctorService.register(obj);
        return "Doctor added successfully";
    }

    @GetMapping("/getAllDoctor")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }
}