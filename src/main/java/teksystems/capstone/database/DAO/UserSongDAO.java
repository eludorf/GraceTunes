package teksystems.capstone.database.DAO;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.capstone.database.Entity.UserSong;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserSongDAO extends JpaRepository<UserSong, Integer> {

//    UserSong findUserSongById(@Param("id") Integer id);
//
//    List<UserSong> findAll();

}
