import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		return (Salesman_Profit(username)/Total_Profit())*100;
	}
	public float Salesman_ExtraSalary(String username,float bonus_amount) {
		float commission = (10/100 * Salesman_Profit(username));
		float bonus = bonus_amount * Salesman_Efficiency(username) / 100;
		return commission + bonus;
	}
	public float Change_bonus_amount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Δώσε νέο ποσό bonus");
		float bonus_amount = sc.nextFloat();
		sc.close();
		return bonus_amount;
	}
}