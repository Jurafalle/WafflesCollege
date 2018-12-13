package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Lecturer;
import sg.iss.wafflescollege.model.Studentgrade;
import sg.iss.wafflescollege.model.Course;

public interface StudentRepository extends JpaRepository<Student, String> {

	@Query("SELECT c.cseCredit FROM Course c, Studentgrade s, Enrollment e WHERE e.student = s.student AND s.stgGrade != '' AND c.cseId = e.course.cseId AND c.cseId = s.course.cseId AND e.student.stuId = :stuID ORDER BY s.stgId")
	Double[] GPACourseCredits(@Param("stuID") String stuID);

	@Query("SELECT s.stgGrade FROM Course c, Studentgrade s, Enrollment e WHERE e.student = s.student AND s.stgGrade != '' AND c.cseId = e.course.cseId AND c.cseId = s.course.cseId AND e.student.stuId = :stuID ORDER BY s.stgId")
	String[] GPAGrades(@Param("stuID") String stuID);

	@Query("SELECT c.cseId FROM Course c, Enrollment e WHERE c.cseId = e.course.cseId AND e.enrStatus != 'Not Approved' AND e.student.stuId = :stuID")
	ArrayList<String> getEnrolledCourseIDs(@Param("stuID") String stuID);
	
	@Query("SELECT c.cseId FROM Course c, Enrollment e WHERE c.cseId = e.course.cseId AND e.student.stuId = :stuID")
	ArrayList<String> getEnrolledCurrentCourseIDs(@Param("stuID") String stuID);

	@Query("SELECT DISTINCT c.cseId FROM Course c, Enrollment e WHERE c.cseId = e.course.cseId AND e.enrStatus != 'Not Approved' AND e.student.stuId = :stuID")
	ArrayList<String> getNewCourseIDs(@Param("stuID") String stuID);

	@Query("SELECT e FROM Enrollment e WHERE e.enrStatus != 'Not Approved' AND e.student.stuId = :stuID")
	ArrayList<Enrollment> getEnrolledCoursesList(@Param("stuID") String stuID);
	
	@Query("SELECT e FROM Enrollment e WHERE e.course.cseId = :cseID AND e.student.stuId = :stuID AND e.enrStatus != 'Approved' AND e.enrStatus != 'Pending' ")
	Enrollment retrieveEnrollment(@Param("cseID") String cseID, @Param("stuID") String stuID);
	
	@Query("SELECT e.enrStatus FROM Enrollment e WHERE e.course.cseId = :cseID AND e.student.stuId = :stuID")
	String retrieveEnrollmentStatus(@Param("cseID") String cseID, @Param("stuID") String stuID);
	
	@Query("SELECT c FROM Course c WHERE c.cseId = :cseID")
	Course retrieveCourse(@Param("cseID") String cseID);
	
	@Query("SELECT l FROM Lecturer l WHERE l.lecId = :lecID")
	Lecturer retrieveLecturer(@Param("lecID") String lecID);
	
	@Query("SELECT s FROM Studentgrade s where s.student.stuId = :stuId AND s.course.cseId = :cseId")
	Studentgrade findStudentgrade(@Param("stuId") String stuId, @Param("cseId") String cseId);

	@Query("SELECT s FROM Student s WHERE s.stuId = :stuId")
	Student findStudentByStuId(@Param("stuId") String stuId);
	
	@Query("SELECT s FROM Student s WHERE s.stuId = :stuId AND s.stuStatus = 'Active'")
	Student findActiveStudentByStuId(@Param("stuId") String stuId);

}
