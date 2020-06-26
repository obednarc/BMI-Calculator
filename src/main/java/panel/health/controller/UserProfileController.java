package panel.health.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import panel.health.model.User;
import panel.health.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserProfileController {

    private final UserService userService;

    @PostMapping("/userProfile")
    public ModelAndView userProfile(@RequestParam Long id) {
        User user = userService.findUserById(id);
        ModelAndView modelAndView = new ModelAndView("userProfile");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/updateUser")
    public ModelAndView updateUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("userProfile");
        modelAndView.addObject("user", user);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        modelAndView.addObject("correctUpdate", "*Pomyślnie zaaktualizowano dane.");
        userService.saveUser(user);
        return modelAndView;
    }

}
