  
import java.sql.*;
import java.util.Scanner;

public class DBMain1 {
	//ΔΟΚΙΜΑΣΤΙΚΗ MAIN
	public static void main(String args[]) {
		DBMain1 obj = new DBMain1();
		float bonus = obj.Change_bonus_amount();//εισαγω νεο ποσο μπονους
		float res;
		res = obj.Salesman_ExtraSalary("s10001",bonus);//βλεπω εξτρα εισοδημα του salesman s10001
		System.out.println(res);
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
