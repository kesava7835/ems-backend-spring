package com.management.service;



import java.util.List;

import com.management.dto.EmployeDto;


public interface EmployeService {
	
	EmployeDto createEmploye(EmployeDto emp);
	
	EmployeDto getEmpolye(Long id);
	
	List<EmployeDto> getAllEmployees();
	
	EmployeDto updateEmploye(Long id,EmployeDto emp);
	
	void deleteEmploye(Long id);

}
