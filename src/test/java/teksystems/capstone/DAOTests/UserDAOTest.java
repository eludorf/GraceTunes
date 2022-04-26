package teksystems.capstone.DAOTests;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;
import teksystems.capstone.database.DAO.UserDAO;
import teksystems.capstone.database.Entity.Song;
import teksystems.capstone.database.Entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
//I have the below line, maybe your lack of this is causing the DB error
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    //Creating user is first thing to do in UserDAOTest, in order to start "Testing users" with your new "fake test user"
    //So for @Order(1) you will want to create a new user.
    //in my test, I'm using User.builder to create the new user.
    //User.builder is defined by adding a @Builder annotation at the top of your User entity class in main.java (near @Getter, @Setter, @Table, etc)
    //The line looks like this in my code:
    //User user = User.builder().firstName("Joe").lastName("Mauer").email("jmauer@twins.com").password("password").build();
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest() {

        User user = User.builder().firstName("Erika").lastName("Ludorf").username("test@gmail.com").password("123456").build();

        userDAO.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void findUserByIdTest() {
        //everything in here looks good but it should come after creating a new fake test user.
        User user = userDAO.findUserById(1);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findUserByUsernameTest() {
        //this method looks good too
        User user = userDAO.findUserByUsername("test@gmail.com");
        Assertions.assertThat(user.getUsername()).isEqualTo("test@gmail.com");
    }

    @Test
    @Order(4)
    public void findAll() {
        //looks right!
        List<User> users = userDAO.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }
}
