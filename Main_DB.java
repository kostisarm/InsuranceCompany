import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class Main_DB {
	public static void main(String args[]) {
		String Username, client_name, client_lastName, client_address, client_nameIns;
		int client_age, cl_insurance_type, cl_insurance_duration;
		float salary,client_bill;
		
		Scanner sc = new Scanner(System.in);
		


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
			rs1 = stmt1.executeQuery("SELECT * FROM Salesman");
			Statement stmt2;
		  	ResultSet rs2;
			while (rs1.next()) {
				Username=rs1.getString("Username");
		        salary=rs1.getFloat("salary");
				stmt2 = dbcon.createStatement();
				rs2 = stmt2.executeQuery("select name,lastName from Employee,Salesman where Employee.Username='"+Username+"'");
				rs2.next();
				String name = rs2.getString("name");
			    String LastName = rs2.getString("lastName");    
				System.out.println(name + " " + LastName + " "+Username + " " + salary);   /* Print all salesmen */
				rs2.close();
				stmt2.close();
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
	  	
	  	Statement stmt7;       /* A manager inserts a new Salesman in the DataBase */
	  	System.out.println("Δώσε username πωλητή");
	  	String sman_username = sc.nextLine();
	  	System.out.println("Δώσε μισθό πωλητή");
	  	float sman_salary = sc.nextFloat();

	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
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
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());
		}
		/*-------------------------------------------*/
	}
}