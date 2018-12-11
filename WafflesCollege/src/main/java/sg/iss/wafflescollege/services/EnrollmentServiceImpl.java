package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.repo.EnrollmentRepository;

public class EnrollmentServiceImpl implements EnrollmentService {

	@Resource
	private EnrollmentRepository enromentRepository;
	
	@Override
	public ArrayList<Enrollment> findAllNewEnrollments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrollment findNewEnrollmentById(String enrollmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Enrollment> findNewEnrollmentsByCriteria(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrollment findEnrollmentById(String enrolmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rejectEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Enrollment> findEnrollmentsByCriteria(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return null;
	}

}
