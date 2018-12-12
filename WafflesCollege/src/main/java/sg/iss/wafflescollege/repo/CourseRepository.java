package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Course;

public interface CourseRepository extends JpaRepository<Course, String> {
	
	@Query("SELECT c FROM Course c where c.lecturer.lecId = :lecId")
	ArrayList<Course> findCourseByLEC_ID(@Param("lecId") String lecId);
	
	@Query("SELECT c FROM Course c where c.cseId = :cseId")
	Course findCourseByCSE_ID(@Param("cseId") String cseId);
	
	
}
