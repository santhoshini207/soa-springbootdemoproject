package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Doctor;
import com.klef.soa.service.DoctorService;

@RestController
public class DoctorController {
  
  //controller->page
  //rest controller->json and responsbody + controller
  
  @Autowired
  private DoctorService service;
  
  @GetMapping("/")
  public String demo() {
    
    return "Spring Boot project";
    
  }
  
  @PostMapping("/add")
  public ResponseEntity<Doctor> adddoctor(@RequestBody Doctor d) { // if client sending json data then use @RequestBody
    Doctor doctor = service.addDoctor(d);
    return ResponseEntity.status(201).body(doctor);         //status code and entity
    
  }
  
  @GetMapping("/displayall")
  public ResponseEntity<List<Doctor>> displayalldoctors() {
    List<Doctor> doctors = service.displayAllDoctors();
    return ResponseEntity.status(200).body(doctors);
    
  }
  
  

}