package com.hospitalmanagmentsystem.Hospital.Management.System.service;


import com.hospitalmanagmentsystem.Hospital.Management.System.models.Bed;
import com.hospitalmanagmentsystem.Hospital.Management.System.repository.BedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BedService {

    @Autowired
    BedRepository bedRepository;

    public Bed getUnOccupiedBedInHospital(UUID hospitalId){

        List<Bed> beds = bedRepository.getAllBeds();

        for(Bed obj : beds){
            if(obj.isBooked() == false && obj.getHospitalId() == hospitalId){
                return obj;
            }
        }

        return null;
    }

    public void addBed(UUID hospitalId){
        Bed obj = new Bed();
        obj.setBedId(UUID.randomUUID());
        obj.setHospitalId(hospitalId);
        bedRepository.addBed(obj);
    }
}
