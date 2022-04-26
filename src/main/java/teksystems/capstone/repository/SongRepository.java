package teksystems.capstone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teksystems.capstone.database.Entity.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {
}

