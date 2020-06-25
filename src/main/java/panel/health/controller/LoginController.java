package panel.health.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import panel.health.dto.UserDto;
import panel.health.model.User;
import panel.health.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userDto", new UserDto());
        return modelAndView;
    }

    @PostMapping(value = "/loginProcess")
    public ModelAndView login(@Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }
        User user = userService.loginUser(userDto);
        if (user != null && user.getUsername().equalsIgnoreCase(userDto.getUsername()) && user.getPassword().equals(userDto.getPassword())) {
            return new ModelAndView("calculator");
        }
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("wrongCredentials", "*Nazwa użytkownika lub hasło jest niepoprawne.");
        return modelAndView;
    }
}