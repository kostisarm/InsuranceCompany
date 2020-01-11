import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public static void Print_All_Efficiencies() {
	String url = "jdbc:sqlserver://195.251.249.161:1433;"+
			"databaseName=DB35;user=G535;password=48tr93905";
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
				}
				catch (SQLException e) {
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
					try {Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
					}	
					catch (SQLException e) {
					System.out.print("SQLException: ");
					System.out.println(e.getMessage());
					}
			}