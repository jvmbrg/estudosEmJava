package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		Worker[] workers = new Worker[10];
		int workerCount = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		int option = 0;
		int x = 0;
		
		while (option!=5) {
			System.out.println("#################################");
			System.out.println("(1) - Register new worker");
			System.out.println("(2) - Register new contract");
			System.out.println("(3) - Search income");
			System.out.println("(4) - List all workers");
			System.out.println("(5) - Exit program");
			System.out.println("#################################");
			System.out.print("Inform your option: ");
			option = sc.nextInt();
			System.out.println("");
			sc.nextLine();
			
			
			switch (option){
				case 1:
					System.out.print("Enter Departament's name: ");
					String departamentName = sc.nextLine();
					System.out.println("-------------------------------");
					
					System.out.println("Enter Worker data: ");
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.println("Level: ");
					System.out.println("| Junior | Pleno | Senior |");
					String level = sc.nextLine();
					System.out.print("Base salary: ");
					double baseSalary = sc.nextDouble();
					Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(departamentName));
					workers[workerCount] = worker;
					workerCount++;
					System.out.println("-------------------------------");
					System.out.println("");
					
					
					
					break;
				case 2:
					/*Aqui foi adicionado um processo onde o usuário primeiro informa o número do trabalhador 
					 *depois o sistema verifica no vetor de trabalhadores cadastrados se é um código válido e só depois
					 *entramos no processo de cadastro de contratos para aquele trabalhador selecionado anteriormente.*/
					System.out.print("Enter worker index add contracts: ");
					int workerIndex = sc.nextInt();
					if (workerIndex <0 || workerIndex > workerCount) {
						System.out.println("Invalid worker index");
						break;
					}
					
					Worker selectedWorker = workers[workerIndex];
					
					System.out.print("How many contracts to this worker? ");
					int n = sc.nextInt();
					for (int i = 0; i <n; i++) {
						System.out.println("Enter contract #" + (i+1) + " data: ");
						Date contractDate = null;
						while(contractDate == null) {	
							try {
								System.out.print("Date -> (DD/MM/YYYY): ");
								String dateInput = sc.next();
								contractDate = sdf.parse(dateInput);
							}catch (ParseException e) {
								System.out.println("Invalid date format. Please enter again");
							}
						}
						
						System.out.print("Value per hour: ");
						double valuePerHour = sc.nextDouble();
						
						System.out.print("Duration hours: ");
						int hours = sc.nextInt();
						
						if (valuePerHour <= 0 || hours<=0) {
							System.out.println("Invalid contract data. Value per hour and duration must be greater than zero.");
							continue;
						}
						
						HourContract hourNewContract = new HourContract(contractDate, valuePerHour, hours);
						selectedWorker.addContract(hourNewContract);
						System.out.println("----------------------------------------------------");
						System.out.println("");
					}
					break;
				case 3:
					System.out.print("Enter worker index income contracts: ");
					workerIndex = sc.nextInt();
					if (workerIndex <0 || workerIndex > workerCount) {
						System.out.println("Invalid worker index");
						break;
					}
					/*	Nessa linha de comando, atribuimos o endereço armazenado no vetor "workers" para a posição escolhida 
					 *	na váriavel de "selectedWorker", dessa forma, temos o objeto reservado e podemos fazer a busca dos 
					 *	contratos associados aquele trabalhador naquela posição.	*/
					selectedWorker = workers[workerIndex];
					
					
					System.out.println("Enter month and year to calculate income (MM/YYYY): ");
					String monthAndYear = sc.next();
					int month = Integer.parseInt(monthAndYear.substring(0, 2));
					int year = Integer.parseInt(monthAndYear.substring(3));
					System.out.println("----------------------------------------------------");
					
					double income = selectedWorker.income(year, month);
					if(income == 0) {
						System.out.println("No contracts found for the specified period.");
					}else {
						
						System.out.println("Name: "+selectedWorker.getName());
						System.out.println("Departament: "+selectedWorker.getDepartament().getName());
						System.out.printf("Income for "+monthAndYear+": "+String.format("%.2f", selectedWorker.income(year, month)));
						System.out.println("");
						System.out.println("----------------------------------------------------");
						System.out.println("");
					}
					break;
				case 4:
					System.out.println("All workers:");
					for (int i = 0; i < workerCount; i++) {
                        Worker w = workers[i];
                        System.out.println("Name: " + w.getName() + ", Department: " + w.getDepartament().getName());
                    }
					
					break;
				case 5:
					System.out.println("Finalizando sistema...");
					break;
				default:
					System.out.println("Invalid option");
				
			}	
		}
		sc.close();
	}
	
}
