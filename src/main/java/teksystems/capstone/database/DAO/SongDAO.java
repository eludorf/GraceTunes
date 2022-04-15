package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongDAO extends JpaRepository<Song, Integer> {

    Song findSongById(@Param("id") Integer id);

    List<Song> findSongBySong_name(@Param("song_name") String song_name);

    List<Song> findSongByArtist_name(@Param("artist_name") String artist_name);

    List<Song> findSongByAlbum_name(@Param("album_name") String album_name);

    List<Song> findSongBySong_time(@Param("song_time") String song_time);

    List<Song> findSongBySong_key(@Param("song_key") String song_key);

    List<Song> findSongBySong_genre(@Param("song_genre") String song_genre);

    List<Song> findSongByUser_id(@Param("user_id") Integer user_id);

    List<Song> findAll();




}

