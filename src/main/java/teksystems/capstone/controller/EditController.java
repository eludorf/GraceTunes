package teksystems.capstone.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.Entity.Song;
import teksystems.capstone.formbean.UpdateSongFormBean;

import javax.validation.Valid;

@Slf4j
@Controller
public class EditController {

    @Autowired
    private SongDAO songDAO;

    @RequestMapping(value = "/user/updatesong", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {
        ModelAndView response = new ModelAndView();

        response.setViewName("user/updatesong");

        return response;
    }

    @RequestMapping(value = "/user/updatesong/{songId}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateSong(@PathVariable("songId") Integer songId) throws Exception {
        ModelAndView response = new ModelAndView();
        log.info("elephants");
        response.setViewName("user/updatesong");

        Song song = songDAO.getById(songId);

        UpdateSongFormBean form = new UpdateSongFormBean();

        form.setSongName(song.getSongName());
        form.setSongTime(song.getSongTime());
        form.setSongKey(song.getSongKey());
        form.setSongGenre(song.getSongGenre());
        form.setArtistName(song.getArtistName());
        form.setAlbumName(song.getAlbumName());

        response.addObject("form", form);


        return response;
    }

    @RequestMapping(value = "/user/updatesongSubmit/{songId}", method = RequestMethod.POST)
    public ModelAndView updateSongSubmit(@Valid UpdateSongFormBean form, @PathVariable("songId") Integer songId) throws Exception {
        ModelAndView response = new ModelAndView();

        Song song = songDAO.getById(songId);

        song.setSongName(form.getSongName());
        song.setSongTime(form.getSongTime());
        song.setSongKey(form.getSongKey());
        song.setSongGenre(form.getSongGenre());
        song.setArtistName(form.getArtistName());
        song.setAlbumName(form.getAlbumName());
log.info(form.getAlbumName());
        songDAO.save(song);
        System.out.println(song.getAlbumName());
        response.addObject("form", form);
        response.setViewName("redirect:/user/landing");
        return response;

    }

}

