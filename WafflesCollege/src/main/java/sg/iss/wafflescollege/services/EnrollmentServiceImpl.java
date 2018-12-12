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
		ArrayList<Enrollment> ulist = (ArrayList<Enrollment>)enrollmentRepo.findAllNewEnrollments();
		return ulist;
	}


	

	@Override
	@Transactional
	public Enrollment approveEnrollment(Enrollment enrollment) {
		return enrollmentRepo.saveAndFlush(enrollment);
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
	public ArrayList<Enrollment> findAllEnrollments() {
		// TODO Auto-generated method stub
		return (ArrayList<Enrollment>) enrollmentRepo.findAll();
	}




	@Override
	@Transactional
	public Enrollment findEnrollmentById(Integer eId) {
		// TODO Auto-generated method stub
		return enrollmentRepo.findById(eId).get();
	}


	}


