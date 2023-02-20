package applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevvel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departamentName = sc.nextLine();
		System.out.println("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String levelWorker = sc.nextLine();
		System.out.print("Base salary: ");
		double workerSalary = sc.nextDouble();
		System.out.print("How many contracts to this worker? ");
		int workerContracts = sc.nextInt();
		
		Worker worker = new Worker(workerName, WorkerLevvel.valueOf(levelWorker), workerSalary, new Departament(departamentName));
		
		for(int i = 1;i <= workerContracts;i++) {
			System.out.print("Enter contract #" + i + "data:");
			System.out.print("Data (dd/MM/yyyy): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valueHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hour = sc.nextInt();
			
			HourContract contracts = new HourContract(contractDate, valueHour, hour);
			worker.addContract(contracts);
		}
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/yyyy): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.print("Name: " + worker.getName());
		System.out.print("Departament: " + worker.getDepartament().getName());
		System.out.println("Income for " + monthAndYear + ": " + worker.income(month, year));
		
		sc.close();
	}

}
