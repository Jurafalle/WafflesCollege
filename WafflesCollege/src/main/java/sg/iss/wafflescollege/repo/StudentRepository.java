package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.model.Course;

public interface StudentRepository extends JpaRepository<Student, String> { 
 
	@Query("SELECT c.cseCredit FROM Course c, Studentgrade s, Enrollment e WHERE e.student = s.student AND e.enrStatus = 'Completed' AND c.cseId = e.course.cseId AND c.cseId = s.course.cseId AND e.student.stuId = :stuID ORDER BY s.stgId")
	Double[] GPACourseCredits(@Param("stuID") String stuID);

	@Query("SELECT s.stgGrade FROM Course c, Studentgrade s, Enrollment e WHERE e.student = s.student AND e.enrStatus = 'Completed' AND c.cseId = e.course.cseId AND c.cseId = s.course.cseId AND e.student.stuId = :stuID ORDER BY s.stgId")
	String[] GPAGrades(@Param("stuID") String stuID);
	
}
