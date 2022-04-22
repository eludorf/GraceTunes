package teksystems.capstone.database.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "review", nullable = false)
    private String review;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name="song_id", referencedColumnName = "id")
    private Song song;

}