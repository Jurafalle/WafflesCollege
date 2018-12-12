package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.repo.CourseRepository;
import sg.iss.wafflescollege.repo.LecturerRepository;

@Service
public class LecturerServiceImpl implements LecturerService {

	@Resource
	LecturerRepository lrepo;
	CourseRepository crepo;
	
	@Override
	@Transactional
	public ArrayList<Course> findCourseTaught(String LEC_ID){
		return crepo.findCourseByLEC_ID(LEC_ID);
	}
	
	@Override
	@Transactional
	public ArrayList<Enrollment> findAllCourseEnrollment(){
		
	}
	
	@Override
	@Transactional
	public ArrayList<Studentgrade> findAllStudentgrade(){
		
	}
}
