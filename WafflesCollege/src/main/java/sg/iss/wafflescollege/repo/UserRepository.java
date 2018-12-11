package sg.iss.wafflescollege.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.iss.wafflescollege.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
