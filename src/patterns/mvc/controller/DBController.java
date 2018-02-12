package patterns.mvc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import patterns.mvc.model.Student;
import patterns.mvc.model.facade.impl.EnglishGrade;
import patterns.mvc.model.facade.impl.MathGrade;
import patterns.mvc.model.facade.impl.PhisicsGrade;

public class DBController {

	private static String dbURL = "jdbc:derby://localhost:1527/WebDB;create=true;user=test;password=test";
	private String studentTableName = "student";
	private String gradeTableName = "grade";
	// jdbc Connection
	private Connection conn = null;

	private Statement stmt = null;
	private static DBController instance;

	private DBController() {
		createConnection();
	}

	private void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			conn = DriverManager.getConnection(dbURL); 
		}
		catch (Exception except) {
			except.printStackTrace();
		}
	}

	public static DBController getInstance() {
		if (instance == null) {
			instance = new DBController();
		}
		return instance;
	}


	public void addStudent(Student student) {
		try
		{
			saveStudent(student);
			saveGrades(student);
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
	}

	private void saveStudent(Student student) throws SQLException {
		stmt = conn.createStatement();
		stmt.execute("insert into " + studentTableName + " (name) values (" +
				student.getName() +"')");
		stmt.close();
	}

	private void saveGrades(Student student) throws SQLException {
		stmt = conn.createStatement();
		ResultSet results = stmt.executeQuery("select * from " + studentTableName + 
				"where id = (select max(id) from " + studentTableName + ")");
		int id = 0;
		while(results.next())
		{
			id = results.getInt("id");
			break;
		}
		results.close();
		stmt.close();
		stmt = conn.createStatement();
		stmt.execute("insert into " + gradeTableName + " (subject, score, userid) values ('" +
				student.getMathGrade().getSubject() + "','" +
				student.getEnglishGrade().getScore() + "','"+
				id + ")");
		stmt.close();
	}

	public List<Student> getStudentList() {
		List<Student> toReturn = new ArrayList<>();
		try
		{
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from " + studentTableName);
			while(results.next())
			{
				int id = results.getInt("id");
				String name = results.getString("name");
				toReturn.add(new Student(id, name));
			}
			results.close();
			for (Student s : toReturn) {
				stmt = conn.createStatement();
				ResultSet results2 = stmt.executeQuery("select * from " + gradeTableName +
						"where userid=" + s.getId());
				while(results2.next())
				{
					String subject = results.getString("subject");
					Double score = Double.valueOf(results.getString("score"));

					if (subject.equals(EnglishGrade.getName())) {
						s.setEnglishGrade(new EnglishGrade(score));
					}
					else if (subject.equals(MathGrade.getName())) {
						s.setMathGrade(new MathGrade(score));
					}
					else if (subject.equals(PhisicsGrade.getName())) {
						s.setPhisicsGrade(new PhisicsGrade(score));
					}
				}
				results.close();
			}
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
		return toReturn;
	}
}
