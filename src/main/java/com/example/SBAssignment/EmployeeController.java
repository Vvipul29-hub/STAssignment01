package com.example.SBAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService empService;

    @GetMapping
    public List<EmployeeEntity> getAllEmployees() {
        return empService.getEmployees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable long id) {
        return empService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity updatedEmp, @PathVariable long id) {
        return empService.updateEmployeeById(id, updatedEmp);
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity newEmp) {
        return empService.addEmployee(newEmp);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeDetails(@PathVariable long id) {
        return empService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{dept}")
    public List<EmployeeEntity> getEmployeesByDepartment(@PathVariable String dept) {
        return empService.getEmployeesByDept(dept);
    }

    @GetMapping("/department/{dept}/min-salary")
    public List<EmployeeEntity> getEmployeeWithMinSalInDept(@PathVariable String dept) {
        return empService.getEmpWithMinSalInDept(dept);
    }

    @GetMapping("/department/{dept}/max-salary")
    public List<EmployeeEntity> getEmployeeWithMaxSalaryInDept(@PathVariable String dept) {
        return empService.getEmpWithMaxSalInDept(dept);
    }

    @GetMapping("/joined-after/{date}")
    public List<EmployeeEntity> getEmployeesJoinedAfterDate(@PathVariable LocalDate date) {
        return empService.getEmployeesJoinedAfterADate(date);
    }

    @GetMapping("/departments/average-salary")
    public List<AverageSalaryPerDepartment> getAvgSalPerDept() {
        return empService.getAvgSalPerDept();
    }

    @GetMapping("/departments/count")
    public List<EmployeesPerDepartment> getEmpCountPerDept() {
        return empService.getEmpCountPerDept();
    }

    @GetMapping("/departments/max-salary")
    public List<HighestSalaryPerDepartment> getMaxSalPerDept() {
        return empService.getMaxSalPerDept();
    }

    @GetMapping("/departments/min-salary")
    public List<LowestSalaryPerDepartment> getMinSalPerDept() {
        return empService.getMinSalPerDept();
    }
}
