package teksystems.capstone.DAOTests;

import org.assertj.core.api.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import teksystems.capstone.database.DAO.SongDAO;
import teksystems.capstone.database.Entity.Song;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SongDAOTest {

    @Autowired
    private SongDAO songDAO;

    @Test
    @Order(1)
    @Rollback(value=false)
    public void createSongTest() {

        Song song = Song.builder().songName("Mighty Warrior").songTime("4:57").songKey("Bb").songGenre("Worship").artistName("Elevation Worship").albumName("Only King Forever").build();

        songDAO.save(song);

        System.out.println(song.getId());
        Assertions.assertThat(song.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void readSongTest() {
        Song song = songDAO.getById(1);
        Assertions.assertThat(song.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfSongs() {
        List<Song> songs = songDAO.findAll();
        Assertions.assertThat(songs.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateSongTest() {
        Song song = songDAO.getById(1);
        song.setArtistName("Hillsong");
        songDAO.save(song);
        Assertions.assertThat(songDAO.findSongById(1).getArtistName()).isEqualTo(song.getArtistName());
        }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteSongTest() {
            Song song = songDAO.getById(1);
            songDAO.delete(song);

            Song songfromdb = songDAO.findSongById(song.getId());

            Assertions.assertThat(songfromdb).isNull();
        }

    @ParameterizedTest
    @Order(6)
    @ValueSource(longs = {1, 2, 3, 4, 5})
    void testSongArray(long arg) {
        Song song = Song.builder().songName("Doxology").songTime("4:39").songKey("G").songGenre("Worship").artistName("Phil Wickham").albumName("Children of God").build();

        songDAO.save(song);

        Assertions.assertThat(arg == song.getId());
    }

}
