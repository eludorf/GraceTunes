package teksystems.capstone.database.DAO;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.Query;
import teksystems.capstone.database.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.capstone.database.Entity.User;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;
import static org.hibernate.hql.internal.antlr.HqlTokenTypes.FROM;

@Repository
public interface SongDAO extends JpaRepository<Song, Integer> {

    @Query("select s from Song s where s.id = :id")
    Song findSongById(Integer id);

    List<Song> findSongBySongName(@Param("song_name") String song_name);

    Song findSongByArtistName(@Param("artist_name") String artist_name);

    Song findSongByAlbumName(@Param("album_name") String album_name);

    Song findSongBySongTime(@Param("song_time") String song_time);

    Song findSongBySongKey(@Param("song_key") String song_key);

    Song findSongBySongGenre(@Param("song_genre") String song_genre);

  List<Song>getSongsBySongNameStartingWith(@Param("song_name")String song_name);

    @Query(value = "SELECT * FROM song", nativeQuery = true)
    List<Song> findAll();

    void deleteSongById(Integer id);

    public List<Song> findSongsByUserContaining(User user);

}

