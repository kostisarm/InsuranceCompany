import java.io.*;
import java.text.*;
import java.util.*;
import java.sql.*;
import java.util.Scanner;

public class Main_DB {
	public static void main(String args[]) {
		String Username, client_name, client_lastName, client_address, client_nameIns;
		int client_age, cl_insurance_type, cl_insurance_duration;
		float salary;
		
		Scanner sc = new Scanner(System.in);
		


		String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;" +
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
			while (rs1.next()) {
				Username=rs1.getString("Username");
			        salary=rs1.getFloat("salary");
				System.out.println(Username + " " + salary);   /* Print all salesmen */
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
	  	
	  	Statement stmt2;       /* DataBase returns all Clients*/
	  	ResultSet rs2;
	  	
	  	
	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
			dbcon = DriverManager.getConnection(url);
			stmt2 = dbcon.createStatement();
			rs2 = stmt2.executeQuery("SELECT * FROM Client");
			while (rs2.next()) {
				client_name=rs2.getString("name");
			    	client_lastName=rs2.getString("lastName");
			    	client_age=rs2.getInt("age");
			    	client_address=rs2.getString("address");
				System.out.println(client_name + " " + client_lastName + " " + client_age + " " + client_address);   /* Print all clients */
			}
		    rs2.close();
		    stmt2.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	  	
	  	Statement stmt3;       /* DataBase returns all Clients' Insurances (for every client)*/
	  	ResultSet rs3;
	  	
	  	
	  	try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");}
	  	catch(java.lang.ClassNotFoundException e)
	  	{System.out.print("ClassNotFoundException: ");
	  	System.out.println(e.getMessage());}

	  	try {
			dbcon = DriverManager.getConnection(url);
			stmt3 = dbcon.createStatement();
			rs3 = stmt3.executeQuery("SELECT * FROM Client_insurances");
			while (rs3.next()) {
				client_nameIns=rs3.getString("name");
				cl_insurance_type=rs3.getInt("insurance_type");
				cl_insurance_duration=rs3.getInt("insurance_duration");
				System.out.println(client_nameIns + " " + cl_insurance_type + " " + cl_insurance_duration);   /* Print all clients' insurances */
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
	  	
	  	Statement stmt4;       /* A salesman inserts a new Client in the DataBase */

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
			stmt4 = dbcon.createStatement();
		    String sql1 = "INSERT INTO Client VALUES ("+cl_name+","+cl_lastName+","+cl_age+","+cl_address+");"; 
		    stmt4.executeUpdate(sql1);
			
		    stmt4.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	  	
	  	
	  	Statement stmt5;       /* A manager inserts a new Salesman in the DataBase */

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
			stmt5 = dbcon.createStatement();
		    String sql2 = "INSERT INTO Salesman VALUES ("+sman_username+","+sman_salary+");"; 
		    stmt5.executeUpdate(sql2);
			
		    stmt5.close();
		    /*dbcon.close();*/
	  	}
		catch(SQLException e)
		{
		System.out.print("SQLException: ");
		System.out.println(e.getMessage());}
		/*-------------------------------------------*/
	}
}
