package teksystems.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.capstone.database.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
