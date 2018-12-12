package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("SELECT c FROM Course c where c.LEC_ID = :LEC_ID")
	ArrayList<Course> findCourseByLEC_ID(@Param("LEC_ID") String LEC_ID);
	
	@Query("SELECT c FROM Course c where c.CSE_ID = :CSE_ID")
	Course findCourseByCSE_ID(@Param("CSE_ID") String CSE_ID);
}
