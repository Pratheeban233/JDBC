package dao;

public class Dao {

	public static void main(String[] args) {
		
		StudentDAO dao=new StudentDAO();
		dao.connection();
		
		//fetching data
		/*
		 * Student s1=dao.getStudent(1);
		 * System.out.println("student name is::"+s1.sname);
		 */
		
		//manipulating data
		Student s2=new Student();
		s2.roll_no=6;
		s2.sname="vino";
		dao.addStudent(s2);
		
		
	}

}
