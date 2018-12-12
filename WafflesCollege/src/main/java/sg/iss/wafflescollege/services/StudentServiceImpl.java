package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository sRepo;
	CourseRepository cRepo;

	@Override
	@Transactional
	public Double CalculateCGPA(String studentID) {
		
		Double[] Credits = sRepo.GPACourseCredits(studentID);
		String[] Grades = sRepo.GPAGrades(studentID);
		Double G = 0.0;
		Double G2 = 0.0;
		int g = 0;
		for (int i = 0; i < Credits.length; i++) {
			switch (Grades[i]) {
			case "A+":
				G = 5.0;
				break;
			case "A":
				G = 5.0;
				break;
			case "A-":
				G = 4.5;
				break;
			case "B+":
				G = 4.0;
				break;
			case "B":
				G = 3.5;
				break;
			case "B-":
				G = 3.0;
				break;
			case "C+":
				G = 2.5;
				break;
			case "C":
				G = 2.0;
				break;
			case "D+":
				G = 1.5;
				break;
			case "D":
				G = 1.0;
				break;
			default:
				G = 0.0;
				break;
			}
			G2 += G * Credits[i];
			g += Credits[i];
		}
		
		return (G2 / g);
	}

	@Override
	public ArrayList<Course> getEnrolledCoursesList(String studentID, String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> getNewCourses(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int enrollIntoCourse(Student s, String courseID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void viewCourseDetails(String courseID) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Student> findAllStudents() {
		// TODO Auto-generated method stub

		return (ArrayList<Student>) sRepo.findAll();
	}

	@Override
	public Student findStudent(String nric) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student createStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStudent(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Student> findStudentsByCriteria(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double convertGradeToGPA(String grade) {
		// TODO Auto-generated method stub
		return null;
	}
}
