package teksystems.capstone.database.DAO;

import teksystems.capstone.database.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, String> {

    Review findReviewByReview(@Param("review") String review);

    List<Review> findReviewByUser_id(@Param("user_id") Integer user_id);

    List<Review> findReviewBySong_id(@Param("song_id") Integer song_id);

    List<Review> findReviewByRating(@Param("rating") Integer rating);

    List<Review> findAll();

}
