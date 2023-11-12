package telran.company.dto;

import java.io.Serializable;

public record SalaryIntervalDistribution(int salaryFrom, int SalaryTo, long amount) 
implements Serializable                                                  // кол-во человек получающий зарплату в опр.интервале
{

}
