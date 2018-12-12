package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Student;

public interface StudentService {

	Double CalculateCGPAByStudentID(String studentID);
	
	Double convertGradeToGPA(String grade);

	ArrayList<Course> getEnrolledCoursesList(String studentID, String status);

	ArrayList<Course> getNewCourses(Student s);

	int enrollIntoCourse(Student s, String courseID);

	void viewCourseDetails(String courseID);
	
	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);

	ArrayList<Student> findStudentsByCriteria(Student student);
}