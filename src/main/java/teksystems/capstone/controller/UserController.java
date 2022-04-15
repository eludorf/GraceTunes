package teksystems.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.formbean.RegisterFormBean;

@Slf4j
@Controller
public class UserController {

    @Autowired
    UserDAO usersDAO;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;

    }

}


