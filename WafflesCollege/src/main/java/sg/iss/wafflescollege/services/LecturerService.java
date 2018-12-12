package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Studentgrade;

public interface LecturerService {

	ArrayList<Course> findCourseTaught(String LEC_ID);
	
	ArrayList<Enrollment> findAllCourseEnrollment();

	ArrayList<Studentgrade> findAllStudentgrade();
	
	
	
	
	
	

}