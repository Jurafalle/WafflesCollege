package sg.iss.wafflescollege.services;

import java.util.ArrayList;

import sg.iss.wafflescollege.model.Course;

public interface CourseService {
	
	ArrayList<Course> findAllCourses();
	Course findCourseById(String courseId);
	int updateCourse(Course course);
	int createCourse(Course course);
	int removeCourse(Course course);
	ArrayList<Course> findCoursesByCriteria(Course course);


}
