package panel.health.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import panel.health.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
