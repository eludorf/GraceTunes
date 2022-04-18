package teksystems.capstone.database.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "song_name", nullable = false)
    private String songName;

    @Column(name = "song_time", nullable = false)
    private String songTime;

    @Column(name = "song_key", nullable = false)
    private String songKey;

    @Column(name = "song_genre", nullable = false)
    private String songGenre;

    @Column(name = "artist_name", nullable = false)
    private String artistName;

    @Column(name = "album_name", nullable = false)
    private String albumName;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "songs")
    private List<UserSong> userList;
}