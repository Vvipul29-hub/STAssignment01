package com.example.SBAssignment;

import com.example.SBAssignment.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    EmployeeRepository empRepo;

    public EmployeeEntity addEmployee(EmployeeEntity empEntity) {
        return empRepo.save(empEntity);
    }

    public String deleteEmployeeById(long id) {
        empRepo.deleteById(id);
        return "Employee "+id+" is deleted successfully!!!";
    }

    public List<EmployeeEntity> getEmployees() {
        return empRepo.findAll();
    }

    public EmployeeEntity getEmployeeById(long id) {
        return empRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee with id "+id+" not found"));
    }

    public EmployeeEntity updateEmployeeById(long id, EmployeeEntity updatedEmp) {
        Optional<EmployeeEntity> currentEmp = empRepo.findById(id);
        if(currentEmp.isPresent()) {
            EmployeeEntity existingEmp = currentEmp.get();
            existingEmp.setDepartment(updatedEmp.getDepartment());
            existingEmp.setName(updatedEmp.getName());
            existingEmp.setSalary(updatedEmp.getSalary());
            existingEmp.setJoinDate(updatedEmp.getJoinDate());
            return empRepo.save(existingEmp);
        } else {
            throw new RuntimeException("Employee with id "+id+" not found.");
        }
    }

    public List<EmployeeEntity> getEmployeesByDept(String dept) {
        return empRepo.findAllByDepartment(dept);
    }

    public List<EmployeeEntity> getEmpWithMinSalInDept(String dept) {
        return empRepo.findEmployeesWithMinimumSalary(dept);
    }

    public List<EmployeeEntity> getEmpWithMaxSalInDept(String dept) {
        return empRepo.findEmployeesWithMaximumSalary(dept);
    }

    public List<EmployeeEntity> getEmployeesJoinedAfterADate(LocalDate date) {
        return empRepo.findEmployeesJoinedAfterCertainDate(date);
    }

    public List<AverageSalaryPerDepartment> getAvgSalPerDept() {
        return empRepo.getAverageSalaryPerDepartment();
    }

    public List<EmployeesPerDepartment> getEmpCountPerDept() {
        return empRepo.getEmployeeCountPerDepartment();
    }

    public List<HighestSalaryPerDepartment> getMaxSalPerDept() {
        return empRepo.getMaximumSalaryPerDepartment();
    }

    public List<LowestSalaryPerDepartment> getMinSalPerDept() {
        return empRepo.getMinimumSalaryPerDepartment();
    }
}
