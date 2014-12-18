package cs544.onlineforumproject.controller;

import cs544.onlineforumproject.domain.User;
import cs544.onlineforumproject.service.IUserService;
import cs544.onlineforumproject.util.Utils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("user")
public class UserController{

    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(String fname, String lname, String email, String password) {
        User user = new User(fname, lname, email, Utils.getMD5Hash(password), "ROLE_USER");
        userService.addUser(user);

        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User userSession, String email, String password) {
        User user = userService.getUser(email);
        String passFromDb = user.getPassword();
        String passFromUser = Utils.getMD5Hash(password);//Hashing the password
        if (passFromUser.equals(passFromDb)) { 
            //userSession.setThisUser(user);
            userSession.setFirstName(user.getFirstName());
            userSession.setUsername(user.getUsername());
            userSession.setId(user.getId());
            return "redirect:/loginSuccess";
        } else {
            return "redirect:/loginFail";
        }
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSucess() {
        return "loginSuccess";
    }

    @RequestMapping(value = "/loginFail", method = RequestMethod.GET)
    public String loginFail() {
        return "loginFail";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        String view=null;        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userService.getUser(email);
        model.addAttribute("user", user);
        if(user.getUserRole().equals("ROLE_USER"))
            view="userWelcome";
        else if(user.getUserRole().equals("ROLE_ADMIN"))
            view="adminWelcome";
                   
        return view;
    }
    
     @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "home";
    }
    
}
