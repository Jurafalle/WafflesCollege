package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.wafflescollege.model.Student;


public interface StudentRepository extends JpaRepository<Student, String> {
 
}
