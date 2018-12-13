package sg.iss.wafflescollege.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
  		 return enrollmentRepo.findAllNewEnrollments();
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
		Date enrolldate = enrollment.getEnrDate();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String eDate = dateFormat.format(enrolldate);
		
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(dateFormat.parse(eDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.add(Calendar.DAY_OF_MONTH, 1);
		eDate = dateFormat.format(c.getTime());
		try {
			enrolldate = dateFormat.parse(eDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		enrollment.setEnrDate(enrolldate);
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
	public Enrollment findEnrollmentById(Integer enrollmentId) {
		// TODO Auto-generated method stub
		return enrollmentRepo.findById(enrollmentId).get();
	}



	@Override
	@Transactional
	public ArrayList<String> findAllStatus() {
		// TODO Auto-generated method stub
		return enrollmentRepo.findAllStatus();
	}



	@Override
	@Transactional
	public ArrayList<String> findAllSID() {
		// TODO Auto-generated method stub
		return enrollmentRepo.findAllStudent();
	}



	@Override
	@Transactional
	public ArrayList<String> findAllCID() {
		// TODO Auto-generated method stub
		return enrollmentRepo.findAllCourse();
	}


	}


