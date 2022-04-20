package teksystems.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.database.Entity.User;
import teksystems.capstone.formbean.RegisterFormBean;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value="/user/register", method = RequestMethod.GET)
    public ModelAndView createUserPage(@RequestParam(required = false)Integer id) throws Exception {
        ModelAndView result = new ModelAndView("/user/register");
        RegisterFormBean form = new RegisterFormBean();
        User user = userDAO.findUserById(id);
        if (user != null) {
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setPassword(user.getPassword());
            userDAO.save(user);
        }
        result.addObject("form", form);
        return result;
    }

    @RequestMapping(value = "/user/registerSubmit", method = RequestMethod.POST)
    public ModelAndView createUserSubmit( RegisterFormBean form) throws Exception {
        ModelAndView response = new ModelAndView();
        User user = new User();
        user.setFirstName(form.getFirstName());
        System.out.println(form.getUsername());
        user.setLastName(form.getLastName());
        user.setUsername(form.getUsername());
        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);
        userDAO.save(user);
        response.setViewName("redirect:/user/landing");
        return response;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/login");
        return response;
    }

//    @RequestMapping(value = "/user/loginSubmit", method = RequestMethod.POST)
//    public ModelAndView loginUserSubmit( RegisterFormBean form) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("redirect:/user/landing");
//        return response;
//    }
}