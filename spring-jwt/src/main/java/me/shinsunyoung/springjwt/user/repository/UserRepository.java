package me.shinsunyoung.springjwt.user.repository;


import java.util.Optional;
import me.shinsunyoung.springjwt.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);
}
