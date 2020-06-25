package panel.health.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panel.health.dao.UserRepository;
import panel.health.dto.UserDto;
import panel.health.model.User;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User loginUser(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername()).orElse(null);
    }

}
