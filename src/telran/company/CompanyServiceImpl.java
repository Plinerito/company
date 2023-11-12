package telran.company;

import java.time.LocalDate;
import java.util.*;

import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;
import telran.company.dto.SalaryIntervalDistribution;

public class CompanyServiceImpl implements CompanyService {
    HashMap<Long, Employee> employeesMap = new HashMap<>();
    HashMap<String, Set<Employee>> employessDepartment = new HashMap<>(); // key - department, value - сет служащих, работающих в этом департаменте
    TreeMap<Integer, Set<Employee>> employeesSalary = new TreeMap<>(); // key - salary, value - сет служащих, имеющих зарплату. 
    TreeMap<LocalDate, Set<Employee>> employeesAge = new TreeMap<>(); // key - birth, value - сет служащих, кто родился в эту жату 
    @Override
	/*
	 * adds new Employee into a company
	 * It the case an employee with the given ID already exists, 
	 * the exception "IllegalStateException" must be throw. 
	 * returns reference to the being added Employee object
	 */
	public Employee hireEmployee(Employee empl) {
    	long id = empl.id();
		if (employeesMap.containsKey(empl.id())) {
			throw new IllegalStateException("Employee already exists" + id);
		}
		employeesMap.put(empl.id(), empl);
		addEmployeeSalary(empl);
		addEmployeeDepartment(empl);
		addEmployeeAe(empl);
		return null;
		
	}

	private void addEmployeeAe(Employee empl) {
		LocalDate birthdate = empl.birthDate();
		Set<Employee> set = employeesAge.computeIfAbsent(birthdate, nk -> new HashSet<Employee>());
		set.add(empl);
		
	}

	private void addEmployeeDepartment(Employee empl) {
		String department = empl.department();		
	//	Set<Employee> set = employessDepartment.computeIfAbsent(department, k -> new HashSet<Employee>());
	//	set.add(empl);
		Set<Employee> set = employessDepartment.get(department);
		if (set == null) {
			set = new HashSet<>();
			employessDepartment.put(department, set);
		}
		set.add(empl);
	}

	private void addEmployeeSalary(Employee empl) {
	// int salary = empl.salary();
		employeesSalary.computeIfAbsent(empl.salary(), k -> new HashSet<>())		
		.add(empl);
	}

	@Override
	/*
	 * removes employee object from company according to a given ID
	 * In the case employee with the given ID doesn't exist 
	 * the method must throw IllegalStateException
	 * 
	 * 
	 */
	public Employee fireEmployee(long id) {
		Employee empl = employeesMap.remove(id);
		if (empl == null) {
			throw new IllegalStateException("Employee not found" + id);
		}
		removeEmployessDepatment(empl);
		removeEmployeesSalary(empl);
		removeEmployeesAge(empl);
		return empl;
	}

	private void removeEmployeesAge(Employee empl) {
		LocalDate birthDate = empl.birthDate();
		Set<Employee> set = employeesAge.get(birthDate);
		set.remove(empl); // removing reference to being removed employee from the set of employees with the given birth date
		if (set.isEmpty()) {
			employeesAge.remove(empl.birthDate());
		}
	}

	private void removeEmployeesSalary(Employee empl) {
		int salary = empl.salary();
		Set<Employee> set = employeesSalary.get(salary);
		set.remove(empl);
		if (set.isEmpty()) {
			employeesSalary.remove(salary);
			
		}
		
	}

	private void removeEmployessDepatment(Employee empl) {
		String department = empl.department();
		Set<Employee> set = employessDepartment.get(department);
		set.remove(empl);
		if(set.isEmpty()) {
			employessDepartment.remove(department);
		}
		
	}

	@Override
	/*
	 * returns referense to Employee object with a given ID value
	 * in the case employee with ID doesn't exist 
	 * the method returns null
	 * 
	 */
	public Employee getEmployee(long id) {
		
		return employeesMap.get(id);
	}

	@Override
	/*
	 * returns list of employee objects working in a given department
	 * in the case none employees in the department, the method returns empty list
	 * 
	 * 
	 */
	public List<Employee> getEmployeesByDepartment(String departmant) {
		// TODO Auto-generated method stub O[1]
		
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeesBySalary(int salaryFrom, int salaryTo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeByAge(int ageFrom, int ageTo) {
		// TODO Auto-generated method stub O[LogN]
		return null;
	}

	@Override
	public List<DepartmentAvgSalary> salaryDistributionByDepartments() {
		// TODO Auto-generated method stub O[N]
		return null;
	}

	@Override
	public List<SalaryIntervalDistribution> getSalaryDistribution(int interval) {
		// TODO Auto-generated method stub O[N]
		return null;
	}

	@Override
	public Employee updateDepartment(long id, String newDepartmant) {
		// TODO Auto-generated method stub O[1]
		return null;
	}

	@Override
	public Employee updateSalary(long id, int newSalary) {
		// TODO Auto-generated method stub O[LogN]
		return null;
	}

	@Override
	public void save(String filePath) {
		// TODO Auto-generated method stub 0[N]

	}

	@Override
	public void restore(String filePath) {
		// TODO Auto-generated method stub O[N]

	}

}
