package sg.iss.wafflescollege.services;

import java.util.ArrayList;
import sg.iss.wafflescollege.model.Enrollment;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sg.iss.wafflescollege.repo.EnrollmentRepository;
@Service
public class EnrollmentServiceImpl implements EnrollmentService {

	@Resource
	private EnrollmentRepository enrollmentRepo;
	
	
	@Override
	@Transactional
	public ArrayList<Enrollment> findAllNewEnrollments() {
		// TODO Auto-generated method stub	
		return enrollmentRepo.findAllNewEnrollments();
	}

	@Override
	@Transactional
	public Enrollment findNewEnrollmentById(String sId) {
		// TODO Auto-generated method stub //??
		return enrollmentRepo.findEnrollmentBysID(sId).get(0);
	}

	@Override
	@Transactional
	public Enrollment approveEnrollment(Enrollment enrollment) {
		return enrollmentRepo.saveAndFlush(enrollment);
		}
	

	@Override
	@Transactional
	public ArrayList<Enrollment> findNewEnrollmentsByCriteria(Enrollment enrollment) {
		// TODO Auto-generated method stub//??
		return null;
	}

	@Override
	public Enrollment findEnrollmentById(String sId) {
		// TODO Auto-generated method stub
		return enrollmentRepo.findEnrollmentBysID(sId).get(0);
	}

	@Override
	@Transactional
	public Enrollment updateEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return enrollmentRepo.saveAndFlush(enrollment);
	}

	@Override
	@Transactional
	public Enrollment createEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return enrollmentRepo.saveAndFlush(enrollment);
	}

	@Override
	@Transactional
	public Enrollment rejectEnrollment(Enrollment enrollment) {
		// TODO Auto-generated method stub
		return enrollmentRepo.saveAndFlush(enrollment);
	}

	@Override
	@Transactional
	public ArrayList<Enrollment> findEnrollmentsByCriteria(Enrollment enrollment) {
		// TODO Auto-generated method stub//??
		return null;
	}
	}


