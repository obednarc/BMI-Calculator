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

import static panel.health.controller.LoginController.loggedUser;

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
        if(user.getNewPassword() != null && !user.getNewPassword().isEmpty()){
            user.updatePassword();
        }
        userService.saveUser(user);
        modelAndView.addObject("correctUpdate", "*Pomyślnie zaaktualizowano dane.");
        return modelAndView;
    }

    @PostMapping("/logout")
    public ModelAndView logoutUser(){
        loggedUser = null;
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject("logout", "*Użytkownik został pomyślnie wylogowany.");
        return modelAndView;
    }
}
