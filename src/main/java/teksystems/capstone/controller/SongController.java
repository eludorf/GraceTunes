package teksystems.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.Entity.Song;
import teksystems.capstone.database.Entity.User;
import org.springframework.transaction.annotation.Transactional;
import teksystems.capstone.formbean.AddSongFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class SongController {

    @Autowired
    private SongDAO songDAO;

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/user/addsong", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/addsong");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        System.out.println(username);
        User user = userDAO.findUserByUsername(username);
        System.out.println(user);
        try {

            AddSongFormBean form = new AddSongFormBean();
            Song newSong = songDAO.findSongById(id);
            if (newSong != null) {

                form.setUserId(user.getId());
                form.setSongName(newSong.getSongName());
                form.setSongTime(newSong.getSongTime());
                form.setSongKey(newSong.getSongKey());
                form.setSongGenre(newSong.getSongGenre());
                form.setArtistName(newSong.getArtistName());
                form.setAlbumName(newSong.getAlbumName());
                form.setId(newSong.getId());
            }
            response.addObject("user", user);
            response.addObject("form", form);
            return response;
        } catch (Exception e) {
            System.out.println("New song could not be created.");
            e.printStackTrace();
            return response;
        }
    }

    @RequestMapping(value = "/user/addsongSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView createSubmit(@Valid AddSongFormBean form, BindingResult bindingResult) throws Exception {
        ModelAndView response = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();

            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages.add(error.getDefaultMessage());
                log.info(((FieldError) error).getField() + " " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.setViewName("user/addsong");
            return response;
        }

        try {
            Song song = new Song();
            song.setSongName(form.getSongName());
            song.setSongTime(form.getSongTime());
            song.setSongKey(form.getSongKey());
            song.setSongGenre(form.getSongGenre());
            song.setArtistName(form.getArtistName());
            song.setAlbumName(form.getAlbumName());

            User userSubmitting = userDAO.findUserById(form.getUserId());
            List<User> userList = song.getUser();
            if (userList != null) {
                userList.add(userSubmitting);
                song.setUser(userList);
            } else {
                List<User> userList2 = new ArrayList<>();
                userList2.add(userSubmitting);
                song.setUser(userList2);
            }
            Song newSong = songDAO.save(song);

            log.info(form.toString());

            response.setViewName("redirect:/user/landing");
            return response;

        } catch (Exception e) {
            System.out.println("New song could not be created.");
            e.printStackTrace();
            return response;
        }
    }

    @GetMapping(value = "/user/search")
    public ModelAndView search(@RequestParam(required = false, defaultValue = "") String songName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<Song> songs = null;
        try {

            if (!songName.isEmpty()) {
                songs = songDAO.getSongsBySongNameStartingWith(songName);
                log.info(songName);
            }
            response.addObject("songsModelKey", songs);
            response.addObject("songName", songName);

            return response;
        } catch (Exception e) {
            System.out.println("Please enter a song name.");
            System.out.println(e);
            return response;
        }
    }

    @GetMapping(value = "/user/searchAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("user/search");

        List<Song> song = null;

        song = songDAO.findAll();

        response.addObject("songModelKey", song);

        return response;
    }

    @Transactional
    @GetMapping(value= "/user/delete")
   public ModelAndView delete(@RequestParam(required = false, defaultValue = " ") Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("redirect:/user/landing");
        try {

            if (!songDAO.existsById(id)) {
                log.info("Song does not exist.");
            }
            songDAO.deleteSongById(id);

            System.out.println("watermelon");

        } catch (Exception e) {
            System.out.println("Please enter a valid song id.");
            return response;
        }
        return response;
    }

    @RequestMapping(value="user/likedsongs", method = {RequestMethod.GET,RequestMethod.POST})
            public ModelAndView likedsongs() throws Exception {
            ModelAndView response = new ModelAndView();

        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userDAO.findUserByUsername(userName);
        System.out.println(u);

        List<Song> likedSongs = songDAO.findSongsByUserContaining(u);
        response.addObject("likedSongs", likedSongs);
        System.out.println(likedSongs);
    return response;
    }


}




