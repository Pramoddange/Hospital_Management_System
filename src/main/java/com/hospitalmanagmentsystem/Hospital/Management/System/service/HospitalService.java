package com.hospitalmanagmentsystem.Hospital.Management.System.service;


import com.hospitalmanagmentsystem.Hospital.Management.System.models.Doctor;
import com.hospitalmanagmentsystem.Hospital.Management.System.models.Hospital;
import com.hospitalmanagmentsystem.Hospital.Management.System.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HospitalService {

    @Autowired
    HospitalRepository hospitalRepository;



    public List<Hospital> getAllHospital(){
        return hospitalRepository.getAllHospital();
    }

    public void registerHospital(Hospital h){
        h.setHospitalID(UUID.randomUUID());
        hospitalRepository.registerHospital(h);
    }

    public Hospital getHospitalByID(UUID id){
        return hospitalRepository.getHospitalById(id);
    }

    public Doctor getMinimumPatientDoctorInHospital(UUID hospitalId){
        Hospital obj  = hospitalRepository.getHospitalById(hospitalId);
        List<Doctor> doctors = obj.getDoctors();
        Doctor minDoctor = null;
        int min = Integer.MAX_VALUE;
        for(Doctor doc : doctors){
            if(min > doc.getPatients().size()){
                min = doc.getPatients().size();
                minDoctor = doc;
            }
        }
        return minDoctor;
    }
}
