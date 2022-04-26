package teksystems.capstone.validation;

import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.Entity.Song;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class SongNameUniqueImpl implements ConstraintValidator<SongNameUnique, String> {

    @Autowired
    private SongDAO songDAO;

    @Override
    public void initialize(SongNameUnique constraintAnnotation) {
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str.isEmpty()) {return true;}
        List<Song> song = songDAO.findSongBySongName(str);
        return (song == null);
    }

}
