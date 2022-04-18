package teksystems.capstone.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.Entity.Song;

import java.util.List;

@Slf4j
@Controller
public class LandingController {

    @Autowired
    private SongDAO songDAO;

    @RequestMapping(value="/user/landing", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();
        List<Song> allSongs = songDAO.findAll();

        response.setViewName("user/landing");
        response.addObject("allSongs", allSongs);
        return response;
    }
}
