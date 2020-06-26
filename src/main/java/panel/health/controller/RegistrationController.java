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
public class RegistrationController {

    private final UserService userService;

    @GetMapping("/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }
        userService.saveUser(user);
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userDto", new UserDto());
        modelAndView.addObject("correctRegister", "*Konto zarejestrowane. Możesz się zalogować.");
        return modelAndView;
    }
}

