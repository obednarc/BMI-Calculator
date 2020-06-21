package panel.health.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import panel.health.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
