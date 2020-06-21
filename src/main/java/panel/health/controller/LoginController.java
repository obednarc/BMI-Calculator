package panel.health.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import panel.health.model.Login;
import panel.health.model.User;
import panel.health.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("login", new Login());
        return modelAndView;
    }


    @PostMapping(value = "/loginProcess")
    public String login(@ModelAttribute("login") Login login, BindingResult bindingResult, ModelMap model) {

        User user = userService.validateUser(login);

        boolean isValidUser = false;

        if (null != user && user.getUsername().equals(login.getUsername())
                && user.getPassword().equals(login.getPassword())) {
            isValidUser = true;
            model.addAttribute("username", user.getUsername());
        }

        return isValidUser ? "welcome" : "login";
    }
}