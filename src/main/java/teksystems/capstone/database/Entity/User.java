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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "first_name", nullable = false, unique = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false, unique = false)
    private String password;
}

