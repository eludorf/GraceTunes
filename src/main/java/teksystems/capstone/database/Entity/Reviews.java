package teksystems.capstone.database.Entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @Column(name = "rating", nullable = false, unique = true)
    private Integer rating;

    @Column(name = "review", nullable = false, unique = true)
    private String review;

    @Column(name = "user_id", nullable = false, unique = true)
    private Integer user_id;

    @Column(name = "song_id", nullable = false, unique = false)
    private Integer song_id;

}