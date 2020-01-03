import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Employee {

	private int id;
	private static int count;
	private static double budget = 4000;
	Scanner sc = new Scanner(System.in);
	
	public Manager(String name, String lastName, String address, String phoneNumber, String password) {
		super(name, lastName, address, phoneNumber, password);
		count++;
		id = count;
		super.setUsername("m" + id);
	}

	public int getId() {
		return id;
	}

	public static double getBudget() {
		return budget;
	}

	public static Employee logIn(String username, String password) {
		for(Employee emp: employee) {
			if(emp instanceof Manager) {
				if(((Manager) emp).getUsername().equals(username)) 
					if(((Manager) emp).getPassword().equals(password)) 
						return emp;
			}
		}
		return null;
	}
	
	@Override
	public void menu() {
		String choice,input;
		
		do {
		System.out.println("1.Ξ£Ο…Ξ½ΞΏΞ»ΞΉΞΊΞ¬ ΞΊΞ­Ο�Ξ΄Ξ· ΞµΟ€ΞΉΟ‡ΞµΞ―Ο�Ξ·ΟƒΞ·Ο‚");
		System.out.println("2.Ξ‘Ξ»Ξ»Ξ±Ξ³Ξ® Ο€ΞΏΟƒΞΏΟ� Ξ�Ο€Ο�Ξ½ΞΏΟ…Ο‚");
		System.out.println("3.Ξ‘Ο€Ο�Ξ΄ΞΏΟƒΞ· Ο…Ο€Ξ±Ξ»Ξ»Ξ®Ξ»Ο‰Ξ½");
		System.out.println("4.Ξ�ΞΉΟƒΞΈΞΏΞ― ΞΊΞ±ΞΉ Ξ�Ο€Ο�Ξ½ΞΏΟ…Ο‚ Ο€Ο‰Ξ»Ξ·Ο„Ο�Ξ½");
		System.out.println("5.Ξ¤Ο�ΞµΞΉΟ‚ ΞΊΞ±Ξ»Ο�Ο„ΞµΟ�ΞΏΞΉ Ο€Ο‰Ξ»Ξ·Ο„Ξ­Ο‚");
		System.out.println("6.Ξ•Ξ³Ξ³Ο�Ξ±Ο†Ξ® Ξ½Ξ­ΞΏΟ… Ο€Ο‰Ξ»Ξ·Ο„Ξ®");
		System.out.print("-->");
		choice = sc.nextLine();
		System.out.println();
		
			switch(choice) {
			case "1" :
				System.out.println("Τα συνολικά κέρδη της επιχείρησης είναι: " + Salesman.TotalProfit());
			case "2" :
				System.out.println("Πληκτρολογήστε το καινούργιο budget για μπόνους: ");
				budget = sc.nextDouble();
			case "3" :
				System.out.println ("Απόδοση υπαλλήλων: ");
				for (int i = 0 ; i < Salesman.salesmen.size() ; i++) {
					System.out.print (Salesman.salesmen.get(i).getLastName() + Salesman.salesmen.get(i).getName());
					System.out.println(": " + Salesman.salesmen.get(i).Efficiency());
				}
			case "4" :
				System.out.println("Μισθοί και μπόνους πωλητών: ");
				
				for (int i = 0 ; i < Salesman.salesmen.size() ; i++) {
					double finalSalary = Salesman.salesmen.get(i).getSalary() + Salesman.salesmen.get(i).ExtraSalary() ;
					System.out.print (Salesman.salesmen.get(i).getLastName() + Salesman.salesmen.get(i).getName());
					System.out.println("Αρχικός μισθός: "+ Salesman.salesmen.get(i).getSalary()  + ", Μπόνους: "+ Salesman.salesmen.get(i).ExtraSalary() 
							+ ", Τελικός μισθός: " + finalSalary);
				}
			case "5" :
			case "6" :
				System.out.print("Παρακαλώ πληκτρολογήστε το όνομα του πωλητή: ");
				String name = sc.nextLine();
				System.out.print("Παρακαλώ πληκτρολογήστε το επώνυμο του πωλητή: ");
				String lname = sc.nextLine();
				System.out.print("Παρακαλώ πληκτρολογήστε τη διεύθυνση του πωλητή: ");
				String address = sc.nextLine();
				System.out.print("Παρακαλώ πληκτρολογήστε τον αριθμό τηλεφώνου του πωλητή: ");
				String pnumber = sc.nextLine();
				System.out.print("Παρακαλώ πληκτρολογήστε τον μισθό του πωλητή: ");
				Double salary = sc.nextDouble();
				System.out.print("Παρακαλώ πληκτρολογήστε τον κωδικό του πωλητή: ");
				String pass = sc.nextLine();
				ArrayList<Client> clients = new ArrayList();
				Salesman s1 = new Salesman(name,lname,address,pnumber,pass,salary,clients);
		}
		} while(true);
		
}
}