package telran.company;

import java.util.List;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public interface CompanyService {
    Employee hireEmployee(Employee empl);   // принять на работу
    Employee fireEmployee(long id);  // уволить
    Employee getEmployee(long id);   // взять работника
    List<Employee> getEmployeesByDepartment(String departmant); 
    List<Employee> getAllEmployees();  
    List<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo);        // получить список сотрудников по зарплате
    List<Employee> getEmployeeByAge(int ageFrom, int ageTo);
    List<DepartmentAvgSalary> salaryDistributionByDepartments();    // средняя зарплата
    List<SalaryIntervalDistribution> getSalaryDistribution(int interval); 
    Employee updateDepartment(long id, String newDepartment);     // поменяьт отдел
    Employee updateSalary(long id, int newSalary);          // повысить работу
    void save(String filePath);
    void restore(String filePath); 
    
    
        
}
