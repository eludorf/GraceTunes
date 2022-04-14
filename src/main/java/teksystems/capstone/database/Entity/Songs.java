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
@Table(name="songs")
public class Songs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "song_name", nullable = false)
    private String song_name;

    @Column(name = "song_time", nullable = false)
    private Long song_time;

    @Column(name = "song_key", nullable = false)
    private String song_key;

    @Column(name = "song_genre", nullable = false)
    private String song_genre;

    @Column(name = "artist_name", nullable = false)
    private String artist_name;

    @Column(name = "album_name", nullable = false)
    private String album_name;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="users_song",
            joinColumns={@JoinColumn(name="song_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")})
    private List<Users> userList;
}