package sg.iss.wafflescollege.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.iss.wafflescollege.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

	@Query("select e from Enrollment e where e.enrStatus ='Pending'")
	ArrayList<Enrollment> findAllNewEnrollments();
	

}
