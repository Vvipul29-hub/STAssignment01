package com.example.SBAssignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByDepartment(String department);
    @Query("""
            select e from EmployeeEntity e where e.department = :dept and e.salary=(
            select MIN(e2.salary) from EmployeeEntity e2 where e2.department = :dept
            )
            """)
    List<EmployeeEntity> findEmployeesWithMinimumSalary(String dept);
    @Query("""
            select e from EmployeeEntity e where e.department = :dept and e.salary=(
            select MAX(e2.salary) from EmployeeEntity e2 where e2.department = :dept
            )
            """)
    List<EmployeeEntity> findEmployeesWithMaximumSalary(String dept);
    @Query("""
            select e from EmployeeEntity e where e.joinDate > :date""")
    List<EmployeeEntity> findEmployeesJoinedAfterCertainDate(LocalDate date);
    @Query("""
            select e.department as department, AVG(e.salary) as avgSal from EmployeeEntity e group by e.department""")
    List<AverageSalaryPerDepartment> getAverageSalaryPerDepartment();
    @Query("""
            select e.department as department, COUNT(e.id) as employeesCount from EmployeeEntity e group by e.department""")
    List<EmployeesPerDepartment> getEmployeeCountPerDepartment();
    @Query("""
            select e.department as department, MAX(e.salary) as maxSalary from EmployeeEntity e group by e.department""")
    List<HighestSalaryPerDepartment> getMaximumSalaryPerDepartment();
    @Query("""
            select e.department as department, MIN(e.salary) as minSalary from EmployeeEntity e group by e.department""")
    List<LowestSalaryPerDepartment> getMinimumSalaryPerDepartment();
}
