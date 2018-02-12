package patterns.mvc.controller;

import java.util.List;

import patterns.mvc.model.Student;

public class StudentController {
	
	private static StudentController studentController;
	
	private StudentController() {
	}
	
	public static StudentController getInstance() {
		if (studentController == null) {
			studentController = new StudentController();
		}
		return studentController;
	}
	
	public void addStudent(Student student) {
		DBController db = DBController.getInstance();
		db.addStudent(student);
	}

	public List<Student> getStudentListDB() {

		DBController db = DBController.getInstance();
		return db.getStudentList();
	}
}
