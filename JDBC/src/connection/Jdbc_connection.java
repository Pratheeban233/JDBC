package connection;

import java.sql.*;

//DDL---Data Defenition language--create, Alter
//DML-- Data manipulation language -- Insert,delete,update
//DQL --Data Query language ---select statements
//TCL-- Transaction control language--grand,revoke

public class Jdbc_connection {

	public static void main(String[] args) throws Exception {
		// String url="jdbc:mysql://localhost:3306/test";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SYSTEM";
		String password = "Prathi#123";

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, user, password);

			// CreateStatment
			String qry = "select * from a_test_db";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);

			while (rs.next()) {
				String output = rs.getString("name") + ":" + rs.getString(2) + ":" + rs.getString(3);
				System.out.println(output);
			}

	/*		// Insert query in create statement
	 
			String name = "michael";
			String company = "own";
			String location = "dindigul";
			String qry1 = "insert into a_test_db values('" + name + "','" + company + "','" + location + "')";
			Statement st1 = con.createStatement();
			int count = st1.executeUpdate(qry1);
			System.out.println(count + "row/s affacted");

			// preparedStatement

			String qry2 = " insert into a_test_db values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(qry2);
			pst.setString(1, "Nirmala");
			pst.setString(2, "home maker");
			pst.setString(3, "Dindigul");
			int count1 = pst.executeUpdate();
			System.out.println(count1 + "row/s affacted");	*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("catch block executed...");
		} finally {

		}
	}

}
