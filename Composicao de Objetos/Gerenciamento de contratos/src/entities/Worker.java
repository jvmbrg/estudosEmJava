package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities_enum.WorkerLevel;

public class Worker {
	//Atributos básicos da classe
	private String name;
	private WorkerLevel level;
	private double baseSalary;
	
	//Associações com outras classes
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {}
	public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	
	//Seção dos métodos da classe, adicionar e remover um contrato
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	
	/*Nesse método foi necessário criar dois atributos locais para receber os valores de ano
	e mês. Também foi necessário instanciar a classe CALENDAR por que só a classe Date não fornece
	ferramentas para que podessemos acessar informações especificas, como foi solicitado por ano
	e mês. */ 
	public double income(int year, int month) {
		double sum = this.getBaseSalary();
		
		//Essa instância Calendar atribui a variável cal a data e hora vigentes no sistema.
		Calendar cal = Calendar.getInstance();
		boolean hasContracts = false;
		for (HourContract c : contracts) {
			
			/* Com o comando cal.setTime(c.getDate()) estamos dizendo instância cal da classe
			   Calendar que queremos que o valor atribuido a ela seja o que foi definido na
			   variavel date, da classe Date, que foi definida na criação de um contrato lá na classe
			   HourContract. Assim, esse date é passado por paramêtro e atribuido a instância cal 
			   atráves do mêtodo modificador set.*/
			cal.setTime(c.getDate());
			
			/* Agora, depois da instância cal ter sido atribuida a data que precisavamos, criamos
			 * duas variaveis para receber o ano o ano e mês correspondetes aquele paramêtro.
			 * Depois, foi só criar um if para verificar se aquele mês e ano passados existem
			 * dentro da lista de contratos. */
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month ==c_month) {
				sum += c.totalValue();
				hasContracts = true;
			}
		}
		/* Aqui utilizamos um operador ternario para verificar se a condição da váriavel hasContracts é verdadeira ou falsa
		 * com base nisso, o método retorna a váriavel sum ou 0. Adicionando essa condição fazemos com que o método só retorne
		 * as informações caso exista um contrato com aquela data passada por parametro.
		 * 
		 * Condições dos operadores ternarios: "condition ? valueIfTrue : valueIfFalse;"*/
		return hasContracts ? sum : 0;
	}
	
}
