package by.tms.tkach.lesson47.repository;

import by.tms.tkach.lesson47.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.firstName= :firstName")
    User findDistinctByFirstName(@Param("firstName") String firstName);

    @Query("SELECT user FROM User user WHERE user.lastName= :lastName")
    User findDistinctByLastName(@Param("lastName") String lastName);
}
