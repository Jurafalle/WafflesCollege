package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Student;

public interface StudentService {

	ArrayList<Student> findAllStudents();

	Student findStudent(String nric);

	Student createStudent(Student s);

	Student updateStudent(Student s);

	void removeStudent(Student s);

	ArrayList<Student> findStudentsByCriteria(Student student);

}