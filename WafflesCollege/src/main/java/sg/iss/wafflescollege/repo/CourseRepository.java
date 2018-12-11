package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.wafflescollege.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
