package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class StudentDAO 
{
	Connection con=null;
	public void connection()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "SYSTEM";
		String password = "Prathi#123";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	public Student getStudent(int roll_no)
	{
		try {
			Student stu=new Student();
			stu.roll_no=roll_no;
			String qry="select sname from a_student where roll_no="+roll_no;
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qry);
			rs.next();
			String name=rs.getNString(1);
			stu.sname=name;
			return stu;
			
		} catch (Exception e) {
			System.out.println("catch...Inside getStudent method");
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public void addStudent(Student s2)
	{
		
		try {
			String qry1="Insert into a_student values (?,?)";

			PreparedStatement pst=con.prepareStatement(qry1);
			pst.setInt(1, s2.roll_no);
			pst.setString(2,s2.sname);
			int  count=pst.executeUpdate();
			System.out.println(count+" student added");
			
		} catch (SQLException e) {
			System.out.println("catch...Inside addStudent method");
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}
}
