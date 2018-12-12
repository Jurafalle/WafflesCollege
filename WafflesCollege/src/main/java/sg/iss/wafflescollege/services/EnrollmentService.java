package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import sg.iss.wafflescollege.model.Enrollment;
@Service
public interface EnrollmentService {
	ArrayList<Enrollment> findAllNewEnrollments();
	Enrollment approveEnrollment(Enrollment enrollment);
	Enrollment findEnrollmentById (Integer enrolmentId);

	ArrayList<Enrollment> findAllEnrollments();
	Enrollment updateEnrollment(Enrollment enrollment);
	Enrollment createEnrollment(Enrollment enrollment);
	Enrollment rejectEnrollment(Enrollment enrollment);



	
}
