package panel.health;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import panel.health.dao.UserRepository;
import panel.health.dto.UserDto;
import panel.health.model.User;
import panel.health.service.UserService;
import panel.health.service.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    private UserService userService;

    @Before
    public void setup(){
        userService = new UserServiceImpl(userRepository);
        userRepository.deleteAll(); // clear table before each test
        userRepository.save(generateDefaultUser()); // save default user to mock database
    }

    @Test
    public void saveUser() {
        // given
        User user = generateDefaultUser();
        user.setUsername("nowy user");

        // when
        userService.saveUser(user);

        // then
        User savedUser = userRepository.findByUsername("nowy user").orElse(null);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("nowy user");
        assertThat(savedUser.getPassword()).isEqualTo("12345");
        assertThat(savedUser.getEmail()).isEqualTo("mail");
        assertThat(savedUser.getFirstName()).isEqualTo("adam");
        assertThat(savedUser.getLastName()).isEqualTo("nowak");
        assertThat(savedUser.getPhone()).isEqualTo("123456789");
    }

    @Test
    public void loginUser(){
        // given
        UserDto existingUserDto = new UserDto();
        existingUserDto.setUsername("mock");
        existingUserDto.setPassword("12345");

        UserDto notExistingUserDto = new UserDto();
        notExistingUserDto.setUsername("empty");
        notExistingUserDto.setPassword("77777");

        // when
        User existingUser = userService.loginUser(existingUserDto);
        User notExistingUser = userService.loginUser(notExistingUserDto);

        // then
        assertThat(existingUser).isNotNull();
        assertThat(existingUser.getUsername()).isEqualTo("mock");
        assertThat(existingUser.getPassword()).isEqualTo("12345");
        assertThat(existingUser.getEmail()).isEqualTo("mail");
        assertThat(existingUser.getFirstName()).isEqualTo("adam");
        assertThat(existingUser.getLastName()).isEqualTo("nowak");
        assertThat(existingUser.getPhone()).isEqualTo("123456789");

        assertThat(notExistingUser).isNull();
    }

    @Test
    public void findUserById(){
        // given
        User alreadySavedUser = userRepository.findByUsername("mock").orElse(null);
        assertThat(alreadySavedUser).isNotNull();

        // when
        User existingUser = userService.findUserById(alreadySavedUser.getId());
        User notExistingUser = userService.findUserById(999L);

        // then
        assertThat(existingUser).isNotNull();
        assertThat(notExistingUser).isNull();
    }

    private User generateDefaultUser() {
        User user = new User();
        user.setUsername("mock");
        user.setPassword("12345");
        user.setEmail("mail");
        user.setFirstName("adam");
        user.setLastName("nowak");
        user.setPhone("123456789");
        return user;
    }
}
