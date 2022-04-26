package teksystems.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.capstone.database.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
