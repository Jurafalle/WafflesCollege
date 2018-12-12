package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Student;
import sg.iss.wafflescollege.model.Enrollment;
import sg.iss.wafflescollege.model.Studentgrade;;

public interface StudentRepository extends JpaRepository<Student, String> {
 
	@Query("SELECT \r\n" + 
			"     s.STG_ID, c.CSE_CREDIT, s.STG_GRADE\r\n" + 
			"FROM\r\n" + 
			"    wafflescollege.course c,\r\n" + 
			"    wafflescollege.studentgrade s,\r\n" + 
			"    wafflescollege.enrollment e\r\n" + 
			"WHERE\r\n" + 
			"    e.STU_ID = s.STU_ID\r\n" + 
			"        AND e.ENR_STATUS = 'Completed'\r\n" + 
			"        AND c.CSE_ID = e.CSE_ID\r\n" + 
			"        AND c.CSE_ID = s.CSE_ID\r\n" + 
			"        AND e.STU_ID = :stuID\r\n" + 
			"\r\n" + 
			"ORDER BY s.STG_ID")
	Double[] GPACourseCredits(@Param("stuID") String stuID);

	@Query("SELECT \r\n" + 
			"     s.STG_ID, c.CSE_CREDIT, s.STG_GRADE\r\n" + 
			"FROM\r\n" + 
			"    wafflescollege.course c,\r\n" + 
			"    wafflescollege.studentgrade s,\r\n" + 
			"    wafflescollege.enrollment e\r\n" + 
			"WHERE\r\n" + 
			"    e.STU_ID = s.STU_ID\r\n" + 
			"        AND e.ENR_STATUS = 'Completed'\r\n" + 
			"        AND c.CSE_ID = e.CSE_ID\r\n" + 
			"        AND c.CSE_ID = s.CSE_ID\r\n" + 
			"        AND e.STU_ID = :stuID\r\n" + 
			"\r\n" + 
			"ORDER BY s.STG_ID")
	String[] GPAGrades(@Param("stuID") String stuID);
	
}
