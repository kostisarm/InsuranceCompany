
import java.sql.*;
import java.util.Scanner;

public class DBMain1 {
	//ΔΟΚΙΜΑΣΤΙΚΗ MAIN
	public static void main(String args[]) {
		DBMain1 obj = new DBMain1();
		//float bonus = obj.Change_bonus_amount();//εισαγω νεο ποσο μπονους
		/*float res;
		res = obj.Salesman_ExtraSalary("s10003",bonus);//βλεπω εξτρα εισοδημα του salesman s10001
		System.out.print("Τα bonus του υπαλλήλου είναι: ");
		System.out.println(res);*/
		obj.Print_All_Salaries();
	}
	public float Client_bill (String Client_name) {	
		String ins_type;
		int ins_dur;
		float ins_cost;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
	"databaseName=DB35;user=G535;password=48tr93905";
		float sum = 0;
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		Statement stmt3;
		ResultSet rs1;
	    ResultSet rs2;
		try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		String clientname = Client_name;
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * FROM Client_insurances WHERE lastName ='"+clientname+("'"));
			stmt2 = dbcon.createStatement();
			stmt3 = dbcon.createStatement();
			while (rs1.next()) {
				ins_type = rs1.getString("insurance_type");
				ins_dur = rs1.getInt("insurance_duration");
				rs2 = stmt2.executeQuery("SELECT cost FROM Service WHERE name = '"+ins_type+("'"));
				while(rs2.next()) {
					ins_cost = rs2.getFloat("cost");
					if (ins_dur == 6) {
						String sql = "UPDATE Client_insurances SET insurance_cost ="+ins_cost+ "where lastName ='"+clientname+"' and insurance_type = '"+ins_type+"' and insurance_duration="+ins_dur; 
						stmt3.executeUpdate(sql);
					} else {
						String sql = "UPDATE Client_insurances SET insurance_cost ="+1.8*ins_cost+ "where lastName ='"+clientname+"' and insurance_type = '"+ins_type+"' and insurance_duration="+ins_dur; 
						stmt3.executeUpdate(sql);
					}
				}
				rs2.close();
			}
			stmt2.close();
			stmt3.close();
			rs1.close();
			stmt1.close();	
			dbcon.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt2 = dbcon.createStatement();
			rs2 = stmt2.executeQuery("SELECT sum(insurance_cost) as sum FROM Client_insurances WHERE lastName ='"+clientname+("'"));
			rs2.next();
			float sum1 = rs2.getFloat("sum");
			sum = sum1;
			stmt2.close();
		} catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			String sql = "UPDATE Client SET bill ="+sum+"where lastName ='"+clientname+("'");
			stmt1.executeUpdate(sql);
			stmt1.close();
	}
		 catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
		 }			
		return sum;
	}
	public float Salesman_Profit(String username) {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
					float sum = 0;
					Connection dbcon;
					Statement stmt1;
					Statement stmt2;
					ResultSet rs1;
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					}
					catch (java.lang.ClassNotFoundException e) {
						System.out.println("ClassNotFoundException: ");
						System.out.println(e.getMessage());
					}
					try {
						dbcon = DriverManager.getConnection(url);
						stmt1 = dbcon.createStatement();
						stmt2 = dbcon.createStatement();
						rs1 = stmt1.executeQuery("SELECT sum(bill) as s from Client where salesman='"+username+"'");
						rs1.next();
						sum = rs1.getFloat("s");
						String sql = "UPDATE Salesman SET profit="+sum+"where Username='"+username+"'"; 
						stmt2.executeUpdate(sql);
						stmt1.close();
						stmt2.close();
						rs1.close();
					}
					 catch (SQLException e) {
							System.out.print("SQLException: ");
							System.out.println(e.getMessage());
					 }	
					return sum;
	}
	public static float Total_Profit() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
					float sum = 0;
					Connection dbcon;
					Statement stmt1;
					ResultSet rs1;
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					}
					catch (java.lang.ClassNotFoundException e) {
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
					}
					 catch (SQLException e) {
							System.out.print("SQLException: ");
							System.out.println(e.getMessage());
					 }	
					return sum;
			}
	public float Salesman_Efficiency(String username) {
		float efficiency = (Salesman_Profit(username)/Total_Profit())*100;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
					Connection dbcon;
					Statement stmt1;
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					}
					catch (java.lang.ClassNotFoundException e) {
						System.out.println("ClassNotFoundException: ");
						System.out.println(e.getMessage());
					}
					try {
						dbcon = DriverManager.getConnection(url);
						stmt1 = dbcon.createStatement();
						stmt1.executeUpdate("UPDATE Salesman SET efficiency="+efficiency+"where Username='"+username+"'");
						stmt1.close();
					}
					catch (SQLException e) {
						System.out.print("SQLException: ");
						System.out.println(e.getMessage());
					}
					return efficiency;
	}
	public float Change_bonus_amount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Δώσε νέο ποσό bonus");
		float bonus_amount = sc.nextFloat();
		sc.close();
		return bonus_amount;
	}
	public float Salesman_ExtraSalary(String username,float bonus_amount) {
		float commission = (10/100 * Salesman_Profit(username));
		float bonus = bonus_amount * Salesman_Efficiency(username) / 100;
		float extra_salary = commission + bonus;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
					Connection dbcon;
					Statement stmt1;
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					}
					catch (java.lang.ClassNotFoundException e) {
						System.out.println("ClassNotFoundException: ");
						System.out.println(e.getMessage());
					}
					try {
						dbcon = DriverManager.getConnection(url);
						stmt1 = dbcon.createStatement();
						stmt1.executeUpdate("UPDATE Salesman SET extra_salary="+extra_salary+"where Username='"+username+"'");
						stmt1.close();
					}
					catch (SQLException e) {
						System.out.print("SQLException: ");
						System.out.println(e.getMessage());
					}
		return extra_salary;
	}
	public static void Print_All_Salaries() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;userG535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		ResultSet rs1;
		ResultSet rs2;
		try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch (java.lang.ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT * from Salesman");
			while (rs1.next()) {
				stmt2 = dbcon.createStatement();
				String username = rs1.getString("Username");
				float salary = rs1.getFloat("salary");
				float extra_salary = rs1.getFloat("extra_salary");
				rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='"+username+"'");
				rs2.next();
				String name = rs2.getString("name");
				String lastName = rs2.getString("lastName");
				System.out.println(name+" "+lastName+" "+salary+" "+extra_salary);
				stmt2.close();
				rs2.close();
			}
			stmt1.close();
			rs1.close();
		}
		catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
		}
		}
	}