package sg.iss.wafflescollege.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.EnrollmentRepository;
import sg.iss.wafflescollege.repo.LecturerRepository;
import sg.iss.wafflescollege.repo.StudentRepository;
import sg.iss.wafflescollege.repo.StudentgradeRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	StudentRepository sRepo;
	CourseRepository cRepo;
	EnrollmentRepository eRepo;
	StudentgradeRepository gRepo;
	LecturerRepository lRepo;

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
	public ArrayList<String> getEnrolledCourseIDs(String stuID) {
		return sRepo.getEnrolledCourseIDs(stuID);
	}

	@Override
	public List<String[]> getNewCourses(String stuID) {
		ArrayList<String> EnrList = sRepo.getEnrolledCourseIDs(stuID);
		Iterator<String> I = EnrList.iterator();
		
		ArrayList<Course> NewCourseList = (ArrayList<Course>) cRepo.findAll();
		ArrayList<String> enrList = sRepo.getEnrolledCourseIDs(stuID);
		
		for (String C : enrList) {
			Course X = cRepo.findCourseByCseId(C);
			NewCourseList.remove(X);
		}
		
	
		
		
		
		
		return null;
	}

	@Override
	public List<String[]> getStudentGrades(String stuID) {
		ArrayList<String> EnrList = sRepo.getEnrolledCourseIDs(stuID);
		Iterator<String> I = EnrList.iterator();

		List<String[]> Display = new ArrayList<String[]>();
		// cseID, cseDesc, cseCredits, studentGrade

		while (I.hasNext()) {
			String cID = I.next();
			Course c = sRepo.retrieveCourse(cID);
			String[] S = new String[4];
			S[0] = c.getCseId();
			S[1] = c.getCseDesc();
			S[2] = String.valueOf(c.getCseCredit());
			Studentgrade G = sRepo.findStudentgrade(stuID, cID);
			String g = G.getStgGrade();
			S[3] = (g != null) ? g : "";

			Display.add(S);
		}

		return Display;
	}

	@Override
	public List<String[]> getEnrolledCourses(String stuID) {
		ArrayList<String> EnrList = sRepo.getEnrolledCurrentCourseIDs(stuID);
		Iterator<String> I = EnrList.iterator();

		List<String[]> Display = new ArrayList<String[]>();
		// cseID, cseDesc, cseCredits, enrStatus, lecturerName

		while (I.hasNext()) {
			String cID = I.next();
			Course c = sRepo.retrieveCourse(cID);
			String[] S = new String[5];
			String e = sRepo.retrieveEnrollmentStatus(cID, stuID);
			switch (e) {
			case "Completed":
				S[3] = "";
				break;
			case "Pending":
				S[3] = "Pending";
				break;
			case "Approved":
				S[3] = "Approved";
				break;
			case "Not Approved":
				S[3] = "";
				break;
			default:
				S[3] = "";
			}
			S[0] = c.getCseId();
			S[1] = c.getCseDesc();
			S[2] = String.valueOf(c.getCseCredit());
			String lID = c.getLecturer().getLecId();
			Lecturer L = sRepo.retrieveLecturer(lID);
			S[4] = L.getLecFirstmidname() + " " + L.getLecLastname();

			if (S[3] != "") {
				Display.add(S);
			}
		} 
		return Display;

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
