package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsDAO extends JpaRepository<Reviews, Integer> {
}
