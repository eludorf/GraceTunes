package teksystems.capstone.database.Entity;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;

    @Column(name = "rating", nullable = false, unique = true)
    private Integer rating;

    @Column(name = "review", nullable = false, unique = true)
    private String review;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @NotNull
    @UniqueElements
    private User user;

    @ManyToOne(targetEntity = Song.class)
    @JoinColumn(name="song_id", referencedColumnName = "id")
    @NotNull
    @UniqueElements
    private Song song;

}