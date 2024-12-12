package com.management.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.management.dto.EmployeDto;
import com.management.service.EmployeService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")  // Corrected typo in URL mapping
public class EmployeController {
    
    private EmployeService empservice;

    // Building an add employee REST API
    @PostMapping("")
    public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto) {
        EmployeDto employe = empservice.createEmploye(employeDto);
        return new ResponseEntity<>(employe, HttpStatus.CREATED);  // Corrected HttpStatus.CREATED
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeDto> getEmploye(@PathVariable Long id){
    	EmployeDto empolye = empservice.getEmpolye(id);
    	return ResponseEntity.ok(empolye);
    	
    }
    @GetMapping
    public ResponseEntity<List<EmployeDto>> getAllEmployee(){
    	List<EmployeDto> allEmployees = empservice.getAllEmployees();
    	return ResponseEntity.ok(allEmployees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeDto> updateEmploye(@PathVariable Long id,@RequestBody EmployeDto emp){
    	EmployeDto updateEmploye = empservice.updateEmploye(id, emp);
    	return ResponseEntity.ok(updateEmploye);
    }
    @DeleteMapping("{id}")
   public ResponseEntity<String>DeleteEmploye(@PathVariable Long id) {
    	empservice.deleteEmploye(id);
    	return ResponseEntity.ok("deleted Succusfully! ");
    	
    }
}
