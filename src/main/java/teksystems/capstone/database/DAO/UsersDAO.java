package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersDAO extends JpaRepository<Users, Integer> {
    List<Users> findAll();

    List<Users> findByUsername(String username);
}
