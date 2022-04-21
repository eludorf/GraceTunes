package teksystems.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.database.DAO.UserRoleDAO;
import teksystems.capstone.database.Entity.Song;
import teksystems.capstone.database.Entity.User;
import teksystems.capstone.database.Entity.UserRole;
import teksystems.capstone.formbean.RegisterFormBean;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private SongDAO songDAO;

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
        user.setLastName(form.getLastName());
        user.setUsername(form.getUsername());
        String password = passwordEncoder.encode(form.getPassword());
        user.setPassword(password);
        userDAO.save(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setUserRole("USER");
        userRoleDAO.save(userRole);
        response.setViewName("redirect:/user/landing");
        return response;
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public ModelAndView login() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/login");
        return response;
    }

    @RequestMapping(value = "/myusername", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }

    @RequestMapping(value = "/addsong", method = RequestMethod.GET)
    @ResponseBody
    public String addLikedSong(@RequestParam(required = false)String username, @RequestParam(required = false)Integer songId) throws Exception {

        Song song = songDAO.findSongById(songId);
        User user = userDAO.findUserByUsername(username);
        List<User> userList = song.getUser();
        if(userList.contains(user)) {
            String string = "Song is already on your list.";
            return string;
        }
        userList.add(user);
        songDAO.save(song);
        System.out.println(user);
        System.out.println(song);
        String string1 = "Song successfully added.";
        return string1;
    }


    }



//    @RequestMapping(value = "/user/loginSubmit", method = RequestMethod.POST)
//    public ModelAndView loginUserSubmit( RegisterFormBean form) throws Exception {
//        ModelAndView response = new ModelAndView();
//        response.setViewName("redirect:/user/landing");
//        return response;
//    }
