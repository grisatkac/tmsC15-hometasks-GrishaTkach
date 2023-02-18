package by.tms.tkach.lesson48.repositories;

import by.tms.tkach.lesson48.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<User, Long> {
}
