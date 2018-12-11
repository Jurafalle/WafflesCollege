package sg.iss.wafflescollege.services;
import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
public interface EnrolmentService {
	ArrayList<Enrollment> findAllNewEnrolments();
	Enrollment findNewEnrolmentById(String enrollmentId);
	int approveEnrolment(Enrollment enrollment);
	ArrayList<Enrollment> findNewEnrolmentsByCriteria(Enrollment enrollment);

	Enrollment findEnrolmentById(String enrolmentId);
	int updateEnrolment(Enrollment enrollment);
	int createEnrolment(Enrollment enrollment);
	int rejectEnrolment(Enrollment enrollment);
	ArrayList<Enrollment> findEnrolmentsByCriteria(Enrollment enrollment);

}