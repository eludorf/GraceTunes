package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

    User findUserById(@Param("id") Integer id);

    User findUserByUsername(@Param("username") String username);

    List<User> findAll();

}
