package panel.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import panel.health.model.User;
import panel.health.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegistrationController {

    @Autowired
    public UserService userService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new User());
        return modelAndView;

    }

    @PostMapping(value = "/registrationProcess")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {
        userService.addUser(user);
        model.addAttribute("username", user.getUsername());

        return "welcome";
    }
}

