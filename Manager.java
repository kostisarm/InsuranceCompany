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

public class Manager {
	static int username = 10005;
	static int salesman_counter = 5;
	static String text;
	static String savetext;
	private int id;
	private static int count;
	private static float budget = 4000;
	Scanner sc = new Scanner(System.in);

	public static void setBudget(float a) {
		budget = a;
	}

	public static float getBudget() {
		return budget;
	}

	public static void Print_All_Efficiencies() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		ResultSet rs1;
		ResultSet rs2;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * from Salesman");
			PrintStream output;
			File file = new File("C:\\Users\\ezisouli\\javaOutputs//efficiencies.txt");
			output = new PrintStream(file);
			while (rs1.next()) {
				stmt2 = dbcon.createStatement();
				String username = rs1.getString("Username");
				float efficiency = rs1.getFloat("efficiency");
				rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='" + username + "'");
				rs2.next();
				String name = rs2.getString("name");
				String lastName = rs2.getString("lastName");
				output.println(name + " " + lastName + " --> Απόδοση: " + efficiency + " %");
				stmt2.close();
				rs2.close();
			}
			int i = 0;
			BufferedReader bf = new BufferedReader(new FileReader(file));
			SalesmanEfficiencies se = new SalesmanEfficiencies();
			while ((text = bf.readLine()) != null) {
				if (i == 0) {
					savetext = text + "\n";
					i++;
				} else {
					savetext += text + "\n";
				}
			}
			se.jTextArea1.setText(savetext);
			se.setVisible(true);
			stmt1.close();
			rs1.close();
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

	public static void Print_All_Salaries() {
		for (int i = 1; i < salesman_counter; i++) { // to update the extra_salary column in the Salesman table
			String s_username = String.format("s1%04d", i); // -"-
			Salesman.Salesman_ExtraSalary(s_username, budget); // -"-
		}
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		ResultSet rs1;
		ResultSet rs2;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * from Salesman");
			PrintStream output;
			File file = new File("C:\\Users\\ezisouli\\javaOutputs//salaries.txt");
			output = new PrintStream(file);
			while (rs1.next()) {
				stmt2 = dbcon.createStatement();
				String username = rs1.getString("Username");
				float salary = rs1.getFloat("salary");
				float extra_salary = rs1.getFloat("extra_salary");
				rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='" + username + "'");
				rs2.next();
				String name = rs2.getString("name");
				String lastName = rs2.getString("lastName");
				output.println(name + " " + lastName + " Μισθός: " + salary + "€ Μπόνους: " + extra_salary + "€");
				stmt2.close();
				rs2.close();
			}
			int i = 0;
			BufferedReader bf = new BufferedReader(new FileReader(file));

			ManagerAllSalaries ms = new ManagerAllSalaries();
			while ((text = bf.readLine()) != null) {
				if (i == 0) {
					savetext = text + "\n";
					i++;
				} else {
					savetext += text + "\n";
				}
			}
			ms.jTextArea1.setText(savetext);
			ms.setVisible(true);
			stmt1.close();
			rs1.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void Top3_Salesmen() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		ResultSet rs1;
		ResultSet rs2;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("select top 3 * from Salesman order by efficiency DESC");
			PrintStream output;
			File file = new File("C:\\Users\\ezisouli\\javaOutputs//Top3Salesmen.txt");
			output = new PrintStream(file);
			while (rs1.next()) {
				String username = rs1.getString("Username");
				stmt2 = dbcon.createStatement();
				rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='" + username + "'");
				rs2.next();
				String name = rs2.getString("name");
				String lastName = rs2.getString("lastName");
				float efficiency = rs1.getFloat("efficiency");
				output.println(name + " " + lastName + " " + username + " --> Απόδοση: " + efficiency + " %");
				stmt2.close();
				rs2.close();
			}
			int i = 0;
			BufferedReader bf = new BufferedReader(new FileReader(file));

			Top3 t3 = new Top3();
			while ((text = bf.readLine()) != null) {
				if (i == 0) {
					savetext = text + "\n";
					i++;
				} else {
					savetext += text + "\n";
				}
			}
			t3.jTextArea1.setText(savetext);
			t3.setVisible(true);
			rs1.close();
			stmt1.close();
			stmt1.close();
			rs1.close();
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

	public static void Create_Salesman_Employee(String emp_name, String emp_lastName, String emp_address,
			String emp_phoneNumber, String sman_username, String emp_password, float sman_salary) {
		String url = "jdbc:sqlserver://195.251.249.161:1433;" + "databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.print("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}

		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			stmt2 = dbcon.createStatement();

			String sql1 = "INSERT INTO Employee VALUES (" + emp_name + "," + emp_lastName + "," + emp_address + ","
					+ emp_phoneNumber + "," + sman_username + "," + emp_password + ");";
			stmt1.executeUpdate(sql1);

			String sql2 = "INSERT INTO Salesman VALUES (" + sman_username + "," + sman_salary + ");";
			stmt2.executeUpdate(sql2);

			stmt1.close();
			stmt2.close();
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}

	}

}