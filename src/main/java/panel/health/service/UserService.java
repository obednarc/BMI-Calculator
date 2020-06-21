package panel.health.service;


import org.springframework.stereotype.Service;
import panel.health.model.Login;
import panel.health.model.User;

@Service
public interface UserService {

    void addUser(User user);

    User validateUser(Login login);
}

