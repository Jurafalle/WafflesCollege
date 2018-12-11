package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Enrollment;

public interface EnrollmentService {
	ArrayList<Enrollment> findAllNewEnrollments();
	ArrayList<Enrollment> findNewEnrollmentById(String enrollmentId);
	int approveEnrollment(Enrollment enrollment);
	ArrayList<Enrollment> findNewEnrollmentsByCriteria(Enrollment enrollment);

	Enrollment findEnrollmentById(String enrollmentId);
	int updateEnrollment(Enrollment enrollment);
	int createEnrollment(Enrollment enrollment);
	int rejectEnrollment(Enrollment enrollment);
	ArrayList<Enrollment> findEnrollmentsByCriteria(Enrollment enrollment);


}
