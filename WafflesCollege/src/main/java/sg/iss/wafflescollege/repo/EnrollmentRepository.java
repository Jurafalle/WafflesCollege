package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.wafflescollege.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

}
