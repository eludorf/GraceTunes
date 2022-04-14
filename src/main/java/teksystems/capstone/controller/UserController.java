package teksystems.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.capstone.database.DAO.SongsDAO;
import teksystems.capstone.database.Entity.Songs;
import teksystems.capstone.database.Entity.Users;
import teksystems.capstone.formbean.RegisterFormBean;

import java.util.List;

@Slf4j
@Controller
public class UserController {

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("form", form);

        return response;

    }

}


