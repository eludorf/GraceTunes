package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.UsersSong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersSongDAO extends JpaRepository<UsersSong, Integer> {
}
