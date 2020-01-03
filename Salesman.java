import java.util.ArrayList;
import java.util.Scanner;

public class Salesman extends Employee{

	private int id;
	private static int count;
	private double salary;
	protected static ArrayList<Salesman> salesmen = new ArrayList();
	protected ArrayList<Client> clients = new ArrayList();
	Scanner sc = new Scanner(System.in);
	
	public Salesman(String name, String lastName, String address, String phoneNumber, String password, double salary, ArrayList<Client> clients) {
		super(name, lastName, address, phoneNumber, password);
		this.salary = salary;
		count++;
		id = count;
		this.clients = clients;
		super.setUsername("s" + id);
		salesmen.add(this);
	}

	public Salesman() {
		super();
	}
	
	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	//log in Ο…Ο€Ξ±Ξ»Ξ»Ξ·Ξ»ΞΏΟ…
	public static Employee logIn(String username, String password) {
		for(Employee emp: employee) {
			if(emp instanceof Salesman) {
				if(((Salesman) emp).getUsername().equals(username)) 
					if(((Salesman) emp).getPassword().equals(password)) 
						
						return emp;
			}
		}
		return null;
	}
	
	@Override
	public void menu() {
		String choice,input;
		
		do {
			System.out.println("1.Προσωπική απόδοση");
			System.out.println("2.Μισθός και Μπόνους");
			System.out.println("3.Πελατολόγιο");
			System.out.println("4.Εγγραφή νέου πελάτη");
			System.out.print("-->");
			choice = sc.nextLine();
			System.out.println();
		
			switch(choice) {
				case "1":
					System.out.println("H προσωπική σας απόδοση: " + Efficiency());
				case "2":
					/*System.out.println("Ο μισθός σας είναι: " + SalesmanProfit() +
							" και το συνολικό σας μπόνους: " + ExtraSalary());*/
					System.out.println("Ο μισθός σας είναι: " + getSalary() +
							"και το συνολικό σας μπόνους: " + ExtraSalary());
				case "3":
					System.out.println("ΠΕΛΑΤΟΛΟΓΙΟ");
					for (Client cli : clients) {
						System.out.println(cli.getName() + " " + cli.getLastName());
					}
				case "4":
					System.out.print("Εισάγετε το όνομα του πελάτη: ");
					String name = sc.nextLine();
					System.out.print("Εισάγετε το επώνυμο του πελάτη: ");
					String lastName = sc.nextLine();
					System.out.print("Εισάγετε την ηλικία του πελάτη: ");
					int age = sc.nextInt();
					System.out.print("Εισάγετε την διεύθυνση  του πελάτη: ");
					String address = sc.nextLine();
					String id;
					ArrayList<Integer[][]> temp = new ArrayList();
					do {
						System.out.println("Εισάγετε το id της ασφάλειας: ");
						id = sc.nextLine();
						if (id.equals("")) {		//enter για να σταματήσει να εισάγει ασφάλειες
							break;
						} else {
							String duration;
							do {
								System.out.println("Εισάγετε τη διάρκεια της ασφάλειας: ");
								duration = sc.nextLine();
								if (id.equals("")) {		//enter για να σταματήσει να εισάγει ασφάλειες
									break;
								} else {
									Integer[][] tempArray = {{Integer.parseInt(id), Integer.parseInt(duration)}};
									temp.add(tempArray);
								}
							} while (true);
						}
					} while (true);
					Client cli = new Client(name, lastName, age, address, temp);
					clients.add(cli);
					temp.clear();
			}
		}while(true);
		
		
	}

	//Κέρδη ανά πωλητή
	public double SalesmanProfit() {
		double sum = 0;
		for(int i = 0; i < clients.size(); i++) {
			sum += clients.get(i).bill();
		}
		return sum;
	}

	//Συνολικά κέρδη επιχείρησης
	public static double TotalProfit() {
		double sum = 0;
		for(int i = 0; i < employee.size(); i++) {
			if (employee.get(i) instanceof Salesman) {
				sum += ((Salesman) employee.get(i)).SalesmanProfit();
			}
		}
		return sum;
	}

	//Αποδοτικότητα 
	public double Efficiency() {
		return this.SalesmanProfit() / TotalProfit();
		
	}

	//Μπόνους ανα Πωλητή (απο το συνολικο μπατζετ)
	public double Bonus() {
		return this.Efficiency() * Manager.getBudget();
	}

	//Προμηθεια ανα Πωλητή
	public double Commission() {
		double sum = 0;
		for(int i = 0; i < clients.size(); i++) {
			for(int j = 0; j < clients.get(i).getInsurance().size(); j++) {
				for(int k = 0; k < Service.services.size(); k++) {
					if(clients.get(i).getInsurance().get(j)[0][0].equals(Service.services.get(k).getId())) {
						sum += 0.1 * Service.services.get(j).getCost();
						break;
					}
				}
			}
		}
		return sum;
	}

	//Συνολικό Μπόνους ανα πωλητή
	public double ExtraSalary() {
		return this.Bonus() + this.Commission();
	}
	
}
