package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.iss.wafflescollege.model.Course;
import sg.iss.wafflescollege.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	
	@Resource
	CourseRepository srepo;
	
	@Override
	public ArrayList<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return (ArrayList<Course>) srepo.findAll();
	}

	@Override
	public Course findCourseById(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCourse(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Course> findCoursesByCriteria(String criteria) {
		// TODO Auto-generated method stub
		return null;
	}

}
