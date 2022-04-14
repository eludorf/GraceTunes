package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongsDAO extends JpaRepository<Songs, Integer> {

}

