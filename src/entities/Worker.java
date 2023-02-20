package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevvel;

public class Worker {
	private String name;
	private WorkerLevvel level;
	private Departament departament;
	private Double baseSalary;
	
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}
	public Worker(String name, WorkerLevvel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.departament = departament;
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevvel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevvel level) {
		this.level = level;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	public double income(int year,int month) {
		double salary = baseSalary;
		Calendar cal = Calendar.getInstance();
		for(HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH) + 1;
			if(year == c_year && month == c_month) {
				salary += c.valueTotal();
			}
		}
		return salary;
	}
}
