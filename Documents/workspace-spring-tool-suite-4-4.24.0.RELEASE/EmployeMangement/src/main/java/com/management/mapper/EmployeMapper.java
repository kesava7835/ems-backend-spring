package com.management.mapper;

import com.management.dto.EmployeDto;
import com.management.entity.Employe;

public class EmployeMapper {
	
	public static EmployeDto mapToDto(Employe emp) {
		return new EmployeDto(
				
				emp.getId(),
				
				emp.getFirstname(),
				emp.getLastname(),
				emp.getEmail()
				
				);
				
				
		
	}
	
	public static Employe mapToEmploye(EmployeDto emp) {
		return new Employe(
				emp.getId(),
				emp.getFirstname(),
				emp.getLastname(),
				emp.getEmail()
				);
	}

}
