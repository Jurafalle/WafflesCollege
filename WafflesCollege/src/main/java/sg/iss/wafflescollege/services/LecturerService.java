package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Studentgrade;

public interface LecturerService {

	ArrayList<Course> findCourseTaught(String lecId);
	
	ArrayList<Course> findAllCourse();
	
	ArrayList<Enrollment> findSpecificCourseEnrollment(String cseId);
	
	Course findCourse(String cseId);
	
	ArrayList<Studentgrade> findSpecificCourseStudentgrade(String cseId);
	
	Studentgrade updateStudentgrade(Studentgrade studentgrade);
	
	ArrayList<Student> findActiveSpecificCourseStudents(String cseId);
	
	Studentgrade findStudentgradeByStgId(int stgId);
	
	String convertToGrade(String score);
	
	ArrayList<Studentgrade> findStudentgradeByStuIdCseId(String stuId, String cseId);
	
	Student findStudentByStuId(String stuId); 
	
	Studentgrade updateStudentGrade(Studentgrade studentgrade);
	
	Student findStudentByStgId(String stgId);
	
	

}