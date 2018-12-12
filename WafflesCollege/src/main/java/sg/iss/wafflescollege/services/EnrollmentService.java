package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.iss.wafflescollege.model.Enrollment;
@Service
public interface EnrollmentService {
	ArrayList<Enrollment> findAllNewEnrollments();
	Enrollment findNewEnrollmentById(String sId);
	Enrollment approveEnrollment(Enrollment enrollment);
	ArrayList<Enrollment> findNewEnrollmentsByCriteria(Enrollment enrollment);

	Enrollment findEnrollmentById(String sId);
	Enrollment updateEnrollment(Enrollment enrollment);
	Enrollment createEnrollment(Enrollment enrollment);
	Enrollment rejectEnrollment(Enrollment enrollment);
	ArrayList<Enrollment> findEnrollmentsByCriteria(Enrollment enrollment);


	
}
