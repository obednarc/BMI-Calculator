package panel.health.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import panel.health.dao.UserRepository;
import panel.health.dto.UserDto;
import panel.health.model.User;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User loginUser(UserDto userDto) {
        return userRepository.findByUsername(userDto.getUsername()).orElse(null);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
