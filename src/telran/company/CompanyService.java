package telran.company;

import java.util.List;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public interface CompanyService {
    Employee hireEmployee(Employee empl);
    Employee fireEmployee(long id);
    Employee getEmployee(long id);
    List<Employee> getEmployeesByDepartment(String departmant);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo);
    List<Employee> getEmployeeByAge(int ageFrom, int ageTo);
    List<DepartmentAvgSalary> salaryDistributionByDepartmants();    // средняя зарплата
    List<SalaryIntervalDistribution> getSalaryDistribution(int interval); 
    Employee updateDepartmant(long id, String newDepartmant);     // отделы
    Employee updateSalary(long id, int newSalary);
    void save(String filePath);
    void restore(String filePath); 
    
    
        
}
