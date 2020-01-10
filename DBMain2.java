import java.sql.*;


public class DBMain {
	//DOKIMASTIKI MAIN
	public static void main(String args[]) {
		DBMain obj = new DBMain();
		float res;
		res = obj.Client_bill("Ioannou");
		System.out.println(res);
	}
	public float Client_bill (String Client_name) {	
		//Scanner sc = new Scanner (System.in);
		//System.out.println("Δώστε επώνυμο πελάτη");
		String ins_type;
		int ins_dur;
		float ins_cost;
		String url = "jdbc:sqlserver://195.251.249.161:1433;"+
	"databaseName=DB35;user=G535;password=48tr93905";
		Connection dbcon;
		Statement stmt1;
		Statement stmt2;
		Statement stmt3;
		Statement stmt4;
		ResultSet rs1;
	    ResultSet rs2;
	    ResultSet rs4;
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
						String sql = "UPDATE Client_insurances SET insurance_cost ="+ins_cost+ "where lastName ='"+clientname+("' and insurance_type = '"+ins_type+"'" ); 
						stmt3.executeUpdate(sql);
					} else {
						String sql = "UPDATE Client_insurances SET insurance_cost ="+1.8*ins_cost+ "where lastName ='"+clientname+("' and insurance_type = '"+ins_type+"'" ); 
						stmt3.executeUpdate(sql);
					}
				}
				rs2.close();
			}
			stmt2.close();
			stmt3.close();
			//sc.close();
			rs1.close();
			stmt1.close();	
			dbcon.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			System.out.println(e.getMessage());
		}
		try {
			dbcon = DriverManager.getConnection(url);
			stmt4 = dbcon.createStatement();
			rs4 = stmt4.executeQuery("SELECT sum(insurance_cost) as sum FROM Client_insurances WHERE lastName ='"+clientname+("'"));
			rs4.next();
			float sum = rs4.getFloat("sum");
			return sum;
			
		} catch (SQLException e) {
				System.out.print("SQLException: ");
				System.out.println(e.getMessage());
				return -1;
		}
	}
	  
}

	