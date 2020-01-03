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
		System.out.println("1.Ξ Ο�ΞΏΟƒΟ‰Ο€ΞΉΞΊΞ® Ξ±Ο€Ο�Ξ΄ΞΏΟƒΞ·");
		System.out.println("2.Ξ�ΞΉΟƒΞΈΟ�Ο‚ ΞΊΞ±ΞΉ Ξ�Ο€Ο�Ξ½ΞΏΟ…Ο‚");
		System.out.println("3.Ξ ΞµΞ»Ξ±Ο„ΞΏΞ»Ο�Ξ³ΞΉΞΏ");
		System.out.println("4.Ξ•Ξ³Ξ³Ο�Ξ±Ο†Ξ® Ξ½Ξ­ΞΏΟ… Ο€ΞµΞ»Ξ¬Ο„Ξ·");
		System.out.print("-->");
		choice = sc.nextLine();
		System.out.println();
		
			switch(choice) {
				case "1":
					System.out.println("H Ο€Ο�ΞΏΟƒΟ‰Ο€ΞΉΞΊΞ® ΟƒΞ±Ο‚ Ξ±Ο€Ο�Ξ΄ΞΏΟƒΞ·: " + Efficiency());
				case "2":
					/*System.out.println("Ξ� ΞΌΞΉΟƒΞΈΟ�Ο‚ ΟƒΞ±Ο‚ ΞµΞ―Ξ½Ξ±ΞΉ: " + SalesmanProfit() +
							" ΞΊΞ±ΞΉ Ο„ΞΏ ΟƒΟ…Ξ½ΞΏΞ»ΞΉΞΊΟ� ΟƒΞ±Ο‚ ΞΌΟ€Ο�Ξ½ΞΏΟ…Ο‚: " + ExtraSalary());*/
					System.out.println("Ο μισθός σας είναι: " + getSalary() +
							"και το συνολικό σας μπόνους: " + ExtraSalary());
				case "3":
					System.out.println("Ξ Ξ•Ξ›Ξ‘Ξ¤Ξ�Ξ›Ξ�Ξ“Ξ™Ξ�");
					for (Client cli : clients) {
						System.out.println(cli.getName() + " " + cli.getLastName());
					}
				case "4":
					System.out.print("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„ΞΏ Ο�Ξ½ΞΏΞΌΞ± Ο„ΞΏΟ… Ο€ΞµΞ»Ξ¬Ο„Ξ·: ");
					String name = sc.nextLine();
					System.out.print("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„ΞΏ ΞµΟ€Ο�Ξ½Ο…ΞΌΞΏ Ο„ΞΏΟ… Ο€ΞµΞ»Ξ¬Ο„Ξ·: ");
					String lastName = sc.nextLine();
					System.out.print("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„Ξ·Ξ½ Ξ·Ξ»ΞΉΞΊΞ―Ξ± Ο„ΞΏΟ… Ο€ΞµΞ»Ξ¬Ο„Ξ·: ");
					int age = sc.nextInt();
					System.out.print("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„Ξ·Ξ½ Ξ΄ΞΉΞµΟ�ΞΈΟ…Ξ½ΟƒΞ·  Ο„ΞΏΟ… Ο€ΞµΞ»Ξ¬Ο„Ξ·: ");
					String address = sc.nextLine();
					String id;
					ArrayList<Integer[][]> temp = new ArrayList();
					do {
						System.out.println("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„ΞΏ id Ο„Ξ·Ο‚ Ξ±ΟƒΟ†Ξ¬Ξ»ΞµΞΉΞ±Ο‚: ");
						id = sc.nextLine();
						if (id.equals("")) {		//enter Ξ³ΞΉΞ± Ξ½Ξ± ΟƒΟ„Ξ±ΞΌΞ±Ο„Ξ®ΟƒΞµΞΉ Ξ½Ξ± ΞµΞΉΟƒΞ¬Ξ³ΞµΞΉ Ξ±ΟƒΟ†Ξ¬Ξ»ΞµΞΉΞµΟ‚
							break;
						} else {
							String duration;
							do {
								System.out.println("Ξ•ΞΉΟƒΞ¬Ξ³ΞµΟ„Ξµ Ο„Ξ· Ξ΄ΞΉΞ¬Ο�ΞΊΞµΞΉΞ± Ο„Ξ·Ο‚ Ξ±ΟƒΟ†Ξ¬Ξ»ΞµΞΉΞ±Ο‚: ");
								duration = sc.nextLine();
								if (id.equals("")) {		//enter Ξ³ΞΉΞ± Ξ½Ξ± ΟƒΟ„Ξ±ΞΌΞ±Ο„Ξ®ΟƒΞµΞΉ Ξ½Ξ± ΞµΞΉΟƒΞ¬Ξ³ΞµΞΉ Ξ±ΟƒΟ†Ξ¬Ξ»ΞµΞΉΞµΟ‚
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

	//Ξ�Ξ­Ο�Ξ΄Ξ· Ξ±Ξ½Ξ¬ Ο€Ο‰Ξ»Ξ·Ο„Ξ®
	public double SalesmanProfit() {
		double sum = 0;
		for(int i = 0; i < clients.size(); i++) {
			sum += clients.get(i).bill();
		}
		return sum;
	}

	//Ξ£Ο…Ξ½ΞΏΞ»ΞΉΞΊΞ¬ ΞΊΞ­Ο�Ξ΄Ξ· ΞµΟ€ΞΉΟ‡ΞµΞ―Ο�Ξ·ΟƒΞ·Ο‚
	public static double TotalProfit() {
		double sum = 0;
		for(int i = 0; i < employee.size(); i++) {
			if (employee.get(i) instanceof Salesman) {
				sum += ((Salesman) employee.get(i)).SalesmanProfit();
			}
		}
		return sum;
	}

	//Ξ‘Ο€ΞΏΞ΄ΞΏΟ„ΞΉΞΊΟ�Ο„Ξ·Ο„Ξ± 
	public double Efficiency() {
		return this.SalesmanProfit() / TotalProfit();
		
	}

	//Ξ�Ο€Ο�Ξ½ΞΏΟ…Ο‚ Ξ±Ξ½Ξ± Ξ Ο‰Ξ»Ξ·Ο„Ξ® (Ξ±Ο€ΞΏ Ο„ΞΏ ΟƒΟ…Ξ½ΞΏΞ»ΞΉΞΊΞΏ ΞΌΟ€Ξ±Ο„Ξ¶ΞµΟ„)
	public double Bonus() {
		return this.Efficiency() * Manager.getBudget();
	}

	//Ξ Ο�ΞΏΞΌΞ·ΞΈΞµΞΉΞ± Ξ±Ξ½Ξ± Ξ Ο‰Ξ»Ξ·Ο„Ξ®
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

	//Ξ£Ο…Ξ½ΞΏΞ»ΞΉΞΊΟ� Ξ�Ο€Ο�Ξ½ΞΏΟ…Ο‚ Ξ±Ξ½Ξ± Ο€Ο‰Ξ»Ξ·Ο„Ξ®
	public double ExtraSalary() {
		return this.Bonus() + this.Commission();
	}
	
}
