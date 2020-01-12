import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class Main_DB {
	public static void main(String args[]) {
		String Username, client_name, client_lastName, client_address, client_nameIns;
		int client_age, cl_insurance_type, cl_insurance_duration;
		float salary, client_bill, bonus = 1000;
		
		Scanner sc = new Scanner(System.in);
		
		Main_DB objective = new Main_DB();//create an objective to execute the methods

		String url = "jdbc:sqlserver://195.251.249.161:1433;" +
	                   "databaseName=DB135;user=G535;password=48tr93905;";
		Connection dbcon ;
		Statement stmt1;       /* DataBase returns all Salesmen*/
	  	ResultSet rs1;
	  
	  	
	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}
	  	
	  	try {
			dbcon = DriverManager.getConnection(url);
			stmt1 = dbcon.createStatement();
			rs1 = stmt1.executeQuery("SELECT name,lastName FROM Employee,Salesman WHERE Employee.Username=Salesman.Username");//to use 1 query instead of 2
			while (rs1.next()) {
				Username=rs1.getString("Username");
		        salary=rs1.getFloat("salary");
				String name = rs1.getString("name");
			    String LastName = rs1.getString("lastName");    
				System.out.println(name + " " + LastName + " "+Username + " " + salary);   /* Print all salesmen */
			}
		    rs1.close();
		    stmt1.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
	  	/*-------------------------------------------*/
	  	
	  	       /* DataBase returns all Clients*/
	  	Statement stmt3;
	  	ResultSet rs3;
	  	
	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
			dbcon = DriverManager.getConnection(url);
			stmt3 = dbcon.createStatement();
			rs3 = stmt3.executeQuery("SELECT * FROM Client");
			while (rs3.next()) {
				client_name=rs3.getString("name");
			    	client_lastName=rs3.getString("lastName");
			    	client_age=rs3.getInt("age");
			    	client_address=rs3.getString("address");
				System.out.println(client_name + " " + client_lastName + " " + client_age + " " + client_address);   /* Print all clients */
			}
		    rs3.close();
		    stmt3.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	  	
	  	Statement stmt4;       /* DataBase returns all Clients' Insurances (for every client)*/
	  	ResultSet rs4;
	  	
	  	
	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
			dbcon = DriverManager.getConnection(url);
			stmt4 = dbcon.createStatement();
			rs4 = stmt4.executeQuery("SELECT * FROM Client_insurances");
			while (rs4.next()) {
				client_nameIns=rs4.getString("lastName");
				cl_insurance_type=rs4.getInt("insurance_type");
				cl_insurance_duration=rs4.getInt("insurance_duration");
				System.out.println(client_nameIns + " " + cl_insurance_type + " " + cl_insurance_duration);   /* Print all clients' insurances */
			}
		    rs4.close();
		    stmt4.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	  	
	  	Statement stmt5;       /* A salesman inserts a new Client in the DataBase */

	  	System.out.println("Δώσε όνομα πελάτη");
	  	String cl_name = sc.nextLine();
	  	System.out.println("Δώσε επώνυμο πελάτη");
	  	String cl_lastName = sc.nextLine();
	  	System.out.println("Δώσε ηλικία πελάτη");
	  	int cl_age = sc.nextInt();
	  	System.out.println("Δώσε διεύθυνση πελάτη");
	  	String cl_address = sc.nextLine();


	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
	  		dbcon = DriverManager.getConnection(url);
			stmt5 = dbcon.createStatement();
		    String sql1 = "INSERT INTO Client VALUES ("+cl_name+","+cl_lastName+","+cl_age+","+cl_address+");"; 
		    stmt5.executeUpdate(sql1);
			
		    stmt5.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	  	Statement stmt6;
	  	do {
			System.out.println("Δώσε τον τύπο της ασφάλειας: ");
			String type = sc.nextLine();
			if (type.equals("")) {		//enter για να σταματήσει να εισάγει ασφάλειες
				break;
			} else {
				String duration;
				do {
					System.out.println("Δώσε τη διάρκεια της ασφάλειας: ");
					duration = sc.nextLine();
					if (type.equals("")) {		//enter για να σταματήσει να εισάγει ασφάλειες
						break;
					} else {
						try {
				  		dbcon = DriverManager.getConnection(url);
						stmt6 = dbcon.createStatement();
					    String sql2 = "INSERT INTO Client_insurances(lastName,insurance_type,insurance_duration) VALUES ("+cl_lastName+","+type+","+duration+");"; 
					    stmt6.executeUpdate(sql2);
					    stmt6.close();
					    /*dbcon.close();*/
				  	}
					catch(SQLException e)
					{
					System.out.print("SQLException: ");
					System.out.println(e.getMessage());
						}	
					}
				} while (true);
			}
		} while (true);
	  	objective.Client_bill(cl_lastName);//update tables in the database
	  	objective.Salesman_ExtraSalary(logIn.Username, bonus);//put the Username from LogIn
	  	
	  	Statement stmt7;       /* A manager inserts a new Salesman in the DataBase */
	  	System.out.println("Δώσε username πωλητή");
	  	String sman_username = sc.nextLine();
	  	System.out.println("Δώσε μισθό πωλητή");
	  	float sman_salary = sc.nextFloat();

	  	try {
	  		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
	  		dbcon = DriverManager.getConnection(url);
			stmt7 = dbcon.createStatement();
		    String sql2 = "INSERT INTO Salesman VALUES ("+sman_username+","+sman_salary+");"; 
		    stmt7.executeUpdate(sql2);
			
		    stmt7.close();
		    /*dbcon.close();*/
	  		}
		catch(SQLException e) {
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());
		}
		/*-------------------------------------------*/
	}
	
	/*METHODS*/
	public static float Client_bill (String Client_name) {	
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
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (java.lang.ClassNotFoundException e) {
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
			stmt1.close();
			stmt2.close();
			stmt3.close();
			rs1.close();
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
		} catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
		 }			
		return sum;
	}
	
	public static float Salesman_Profit(String username) {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
						rs1 = stmt1.executeQuery("SELECT sum(bill) as s from Client where salesman='"+username+"'");
						rs1.next();
						sum = rs1.getFloat("s");
						String sql = "UPDATE Salesman SET profit="+sum+"where Username='"+username+"'"; 
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
	
	public static float Total_Profit() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
	
	public static float Salesman_Efficiency(String username) {
		float efficiency = (Salesman_Profit(username)/Total_Profit())*100;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
						stmt1.executeUpdate("UPDATE Salesman SET efficiency="+efficiency+"where Username='"+username+"'");
						stmt1.close();
					} catch (SQLException e) {
						System.out.print("SQLException: ");
						System.out.println(e.getMessage());
					}
					return efficiency;
	}

	public static void Print_All_Efficiencies() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
						while (rs1.next()) {
							stmt2 = dbcon.createStatement();
							String username = rs1.getString("Username");
							float Efficiency = rs1.getFloat("efficiency");
							rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='"+username+"'");
							rs2.next();
							String name = rs2.getString("name");
							String lastName = rs2.getString("lastName");
							System.out.println(name+" "+lastName+" "+Efficiency);
							stmt2.close();
							rs2.close();	
						}
						stmt1.close();
						rs1.close();
					} catch (SQLException e) {
						System.out.print("SQLException: ");
						System.out.println(e.getMessage());
					}
	}
	
	public static float Change_bonus_amount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Δώσε νέο ποσό bonus");
		float bonus_amount = sc.nextFloat();
		sc.close();
		return bonus_amount;
	}

	public static float Salesman_ExtraSalary(String username,float bonus_amount) {
		float commission = (10/100 * Salesman_Profit(username));
		float bonus = bonus_amount * Salesman_Efficiency(username) / 100;
		float extra_salary = commission + bonus;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
						stmt1.executeUpdate("UPDATE Salesman SET extra_salary="+extra_salary+"where Username='"+username+"'");
						stmt1.close();
					} catch (SQLException e) {
						System.out.print("SQLException: ");
						System.out.println(e.getMessage());
					}
		return extra_salary;
	}
	public static void Print_All_Salaries() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
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
		} catch (SQLException e) {
			System.out.print("SQLException: ");
			System.out.println(e.getMessage());
			}
		}
	
	public static void Top3_Salesmen() {
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
				"databaseName=DB35;user=G535;password=48tr93905";
					Connection dbcon;
					Statement stmt1;
					Statement stmt2;
					ResultSet rs1;
					ResultSet rs2;
					try {
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					}
					catch (java.lang.ClassNotFoundException e) {
						System.out.println("ClassNotFoundException: ");
						System.out.println(e.getMessage());
					}
					try {
						dbcon = DriverManager.getConnection(url);
						stmt1 = dbcon.createStatement();
						rs1 = stmt1.executeQuery("select top 3 * from Salesman order by efficiency DESC");
						while (rs1.next()){
							String username = rs1.getString("Username");
							stmt2 = dbcon.createStatement();
							rs2 = stmt2.executeQuery("SELECT name,lastName FROM Employee where Username ='"+username+"'");
							rs2.next();
							String name = rs2.getString("name");
							String lastName = rs2.getString("lastName");
							System.out.println(name+" "+lastName+" "+username);
							stmt2.close();
							rs2.close();
						}
						stmt1.close();
						rs1.close();
					} catch (SQLException e) {
					System.out.print("SQLException: ");
					System.out.println(e.getMessage());
					}
			}
}