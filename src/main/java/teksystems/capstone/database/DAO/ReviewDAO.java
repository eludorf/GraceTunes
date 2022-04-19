package teksystems.capstone.database.DAO;

import org.springframework.data.jpa.repository.Query;
import teksystems.capstone.database.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDAO extends JpaRepository<Review, String> {

    Review findReviewByReview(@Param("review") String review);

    Review findByuser_id(@Param("user_id") Integer user_id);

    List<Review> findReviewBySongId(@Param("song_id") Integer song_id);

    List<Review> findReviewByRating(@Param("rating") Integer rating);

    List<Review> findAll();

    @Query("select r from Review r where")

}
