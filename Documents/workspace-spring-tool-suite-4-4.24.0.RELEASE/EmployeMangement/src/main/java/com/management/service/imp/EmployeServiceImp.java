package com.management.service.imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.management.dto.EmployeDto;
import com.management.entity.Employe;
import com.management.exceptions.ResourceNotFoundException;
import com.management.mapper.EmployeMapper;
import com.management.repository.EmployeRepository;
import com.management.service.EmployeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeServiceImp implements EmployeService {

    private EmployeRepository repo; // Constructor injection done by Lombok's @AllArgsConstructor

    @Override
    public EmployeDto createEmploye(EmployeDto emp) {
      
        Employe empsave = EmployeMapper.mapToEmploye(emp);

     
        repo.save(empsave);

      
        return EmployeMapper.mapToDto(empsave);
    }

	@Override
	public EmployeDto getEmpolye(Long id) {
		Employe employe=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee with the id was not found" + id));
		
		return EmployeMapper.mapToDto(employe);
	}

	@Override
	public List<EmployeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employe> all = repo.findAll();
		
		return all.stream().map(employee -> EmployeMapper.mapToDto(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeDto updateEmploye(Long id, EmployeDto emp) {
		Employe employe=repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("For Updation the employe not found in id of " + id) );
		employe.setEmail(emp.getEmail());
		employe.setFirstname(emp.getFirstname());
		employe.setLastname(emp.getLastname());
		Employe save = repo.save(employe);
		return EmployeMapper.mapToDto(save);
	}

	@Override
	public void deleteEmploye(Long id) {
		// TODO Auto-generated method stub
		Employe orElseThrow = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employe for deletion with id NOt found  "+ id));
		repo.deleteById(id);
	}
}
