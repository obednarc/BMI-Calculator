package panel.health.service;


import org.springframework.stereotype.Service;
import panel.health.dto.UserDto;
import panel.health.model.User;

@Service
public interface UserService {

    void saveUser(User user);

    User loginUser(UserDto userDto);

    User findUserById(Long id);
}

