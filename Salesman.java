import java.sql.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Salesman {

	static String text;
	static String savetext;
	private int id;
	private static int count;
	private double salary;
	protected static ArrayList<Salesman> salesmen = new ArrayList();
	protected ArrayList<Client> clients = new ArrayList();
	Scanner sc = new Scanner(System.in);

	// Κέρδη ανά πωλητή
	public static float Salesman_Profit(String username) {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		float sum = 0;
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		ResultSet rs1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			stmt2 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT sum(bill) as s from Client where salesman='" + username + "'");
			rs1.next();
			sum = rs1.getFloat("s");
			String sql = "UPDATE Salesman SET profit=" + sum + "where Username='" + username + "'";
			stmt2.executeUpdate(sql);
			stmt1.close();
			stmt2.close();
			rs1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		return sum;
	}

	// Συνολικά κέρδη επιχείρησης
	public static float Total_Profit() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		float sum = 0;
		Connection dbcon;
		Statement stmt1;
		ResultSet rs1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT sum(bill) as s from Client");
			rs1.next();
			sum = rs1.getFloat("s");
			stmt1.close();
			rs1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		return sum;
	}

	// Αποδοτικότητα
	public static float Salesman_Efficiency(String username) {
		float efficiency = (Salesman_Profit(username) / Total_Profit()) * 100;
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			stmt1.executeUpdate("UPDATE Salesman SET efficiency=" + efficiency + "where Username='" + username + "'");
			stmt1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		return efficiency;
	}

	public static void Salesman_Clients() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905;";
		Connection dbcon;
		Statement stmt1; /* DataBase returns all Salesmen */
		ResultSet rs1;

		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * FROM Client ");
			PrintStream output;
			File file = new File("C:\\Users\\ezisouli\\javaOutputs//clients.txt");
			output = new PrintStream(file);
			output.println("Οι πελάτες σας είναι: ");
			while (rs1.next()) {
				String salesman = rs1.getString("salesman");
				if (salesman.equals(LogIn.usernameS)) {
					String name = rs1.getString("name");
					String lname = rs1.getString("lastName");
					int age = rs1.getInt("age");
					String address = rs1.getString("address");
					System.setOut(output);
					output.println("Όνομα Πελάτη: " + name + " Επώνυμο Πελάτη: " + lname + " Ηλικία: " + age
							+ " Διεύθυνση Κατοικίας: " + address);
				}
			}
			int i = 0;
			BufferedReader bf = new BufferedReader(new FileReader(file));

			Clients cl = new Clients();
			while ((text = bf.readLine()) != null) {
				if (i == 0) {
					savetext = text + "\n";
					i++;
				} else {
					savetext += text + "\n";
				}
			}
			cl.jTextArea1.setText(savetext);
			cl.setVisible(true);
			rs1.close();
			stmt1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Συνολικό Μπόνους ανα πωλητή
	public static float Salesman_ExtraSalary(String username, float bonus_amount) {
		float commission = (10 / 100 * Salesman_Profit(username));
		float bonus = bonus_amount * Salesman_Efficiency(username) / 100;
		float extra_salary = commission + bonus;
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			stmt1.executeUpdate(
					"UPDATE Salesman SET extra_salary=" + extra_salary + "where Username='" + username + "'");
			stmt1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		return extra_salary;
	}

}
