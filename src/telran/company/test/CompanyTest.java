package telran.company.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.DefaultParsingContext;

import telran.company.CompanyService;
import telran.company.CompanyServiceImpl;
import telran.company.dto.DepartmentAvgSalary;
import telran.company.dto.Employee;

class CompanyTest {
private static final long ID1 = 123;
private static final long ID2 = 124;
private static final int SALARY1 = 5000;
private static final int SALARY2 = 6000;
private static final String DEPARTMENT1 = "Dep1";
private static final LocalDate DATE1 = LocalDate.of(1970, 10, 23);
private static final LocalDate DATE2 = LocalDate.of(1975, 1, 1);
private static final long ID3 = 125;
private static final long ID4 = 126;
private static final long ID5 = 127;
private static final int SALARY3 = 7000;
private static final int SALARY4 = 8000;
private static final int SALARY5 = 9000;
private static final String DEPARTMENT2 = "dep2";
private static final String DEPARTMENT3 = "dep3";
private static final LocalDate DATE3 = LocalDate.of(1980, 5, 3);
private static final LocalDate DATE4 = LocalDate.of(1990, 5, 3);
private static final LocalDate DATE5 = LocalDate.of(2000, 5, 3);
private static final long ID6 = 1000;
private static final String DEPARTMENT6 = "Audit";
Employee empl1 = new Employee(ID1, "name1", SALARY1, DEPARTMENT1, DATE1);
Employee empl2 = new Employee(ID2, "name2", SALARY2, DEPARTMENT1, DATE2);
Employee empl3 = new Employee(ID3, "name3", SALARY3, DEPARTMENT2, DATE3);
Employee empl4 = new Employee(ID4, "name4", SALARY4, DEPARTMENT2, DATE4);
Employee empl5 = new Employee(ID5, "name5", SALARY5, DEPARTMENT3, DATE5);
Employee[] employees = {empl1,empl2,empl3,empl4,empl5};
CompanyService company;                                       // спросить про строку
	@BeforeEach
	void setUp() throws Exception {                               // first test hire on the job
		company = new CompanyServiceImpl();                     // create new company
		for(Employee empl: employees) {
			company.hireEmployee(empl);                         // add Employee on work
		
		}
	}

	@Test
	void testHireEmployeeNormal() {
		Employee newEmployee = new Employee(ID6, "name6", SALARY1, DEPARTMENT1, DATE1);
		assertEquals(newEmployee, company.hireEmployee(newEmployee));    // содержит два аргумента
	}
	
	void testHireEmployeeException() {
		Employee newEmployee = empl1;
		// FIXME 
		boolean flException = false; 
		try {
			company.hireEmployee(newEmployee);
		} catch(IllegalStateException e) {                      // 
			flException = true;
		}
		assertEquals(flException, true);             // first object wait argument, second object fact argument.
		
	}

	@Test
	void testFireEmployeeNormal() {                  // come back link on delete employee 
		assertEquals(empl1,company.fireEmployee(ID1));               // delete employee
		assertEquals(empl1,company.hireEmployee(empl1));             // разобраться
	}
	
	@Test
	void testFireEmployeeException() {
		boolean flException = false;
		try {
			company.fireEmployee(ID6);
		} catch (IllegalStateException e) {
			flException = true;
		}
		assertTrue(flException);
	}

	@Test
	void testGetEmployee() {
		assertEquals(empl1,company.getEmployee(ID1));
		assertNull(company.getEmployee(ID6));
	}

	@Test
	void testGetEmployeesByDepartment() {
		Employee [] expectedDep1 = {empl1,empl2};
		Employee [] expectedDep2 = {empl3,empl4};
		List<Employee> list1 = company.getEmployeesByDepartment(DEPARTMENT1);
		List<Employee> list2 = company.getEmployeesByDepartment(DEPARTMENT2);
		Employee [] actualDep1 = list1.toArray(new Employee[] {});  // получить массив из списка
		Employee [] actualDep2 = list2.toArray(new Employee[] {});
		Arrays.sort(actualDep1);
		Arrays.sort(actualDep2);
		assertTrue(company.getEmployeesByDepartment(DEPARTMENT6).isEmpty());
		assertArrayEquals(expectedDep1,actualDep1);
		assertArrayEquals(expectedDep2, actualDep2);
	}

	@Test
	void testGetAllEmployees() {
		Employee [] expectedAll = {empl1,empl2,empl3,empl4,empl5};
		List <Employee> list3 = company.getAllEmployees();
		Employee [] actualAll = list3.toArray(new Employee[] {});
		Arrays.sort(actualAll);
		assertArrayEquals(expectedAll, actualAll);
	}

	@Test
	void testGetEmployeesBySalary() {
		// TODO HW №22
	}

	@Test
	void testGetEmployeeByAge() {                               // give me all employees into age from 28 to 35
		List<Employee> listAll = company.getEmployeeByAge(0, 100); 
		Employee[] actualAll = listAll.toArray(new Employee[] {});
		Arrays.sort(actualAll);
		assertArrayEquals(employees,actualAll);
		List<Employee> listEmpty = company.getEmployeeByAge(90, 100);
		assertTrue(listEmpty.isEmpty());
		List<Employee> list2_3 = company.getEmployeeByAge(getAge(DATE3), getAge(DATE1));
		Employee[] actual2_3 = list2_3.toArray(new Employee[] {});
		Employee[] expected2_3 = {empl2, empl3};
		Arrays.sort(actual2_3);
		assertArrayEquals(expected2_3, actual2_3);
		
	}

	@Test
	void testSalaryDistributionByDepartmants() {                                            //
		DepartmentAvgSalary[] expectedDistribution =
				
			{new DepartmentAvgSalary(DEPARTMENT1, (SALARY1 + SALARY2) / 2), 
			 new DepartmentAvgSalary(DEPARTMENT2, (SALARY3 + SALARY4) / 2), 
			 new DepartmentAvgSalary(DEPARTMENT3, SALARY5)
			};
			  List<DepartmentAvgSalary> listDistribution = company.salaryDistributionByDepartments();
			  DepartmentAvgSalary [] actualDistribution = 
					  listDistribution.toArray(new DepartmentAvgSalary[] {}); // для чего получаем массив? 
			  Arrays.sort(actualDistribution);
			  assertArrayEquals(expectedDistribution, actualDistribution);
		}
	

	@Test
	void testGetSalaryDistribution() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateDepartmant() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateSalary() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testRestore() {
		fail("Not yet implemented");
	}
	private int getAge(LocalDate birthdate) {
		int result = (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
		return result;
	}

}
