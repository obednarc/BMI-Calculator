package panel.health.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import panel.health.dao.UserRepository;
import panel.health.model.Login;
import panel.health.model.User;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepo;

    public void addUser(User user) {
        userRepo.save(user);
    }

    public User validateUser(Login login) {
        return userRepo.findById(login.getUsername()).get();
    }

}
