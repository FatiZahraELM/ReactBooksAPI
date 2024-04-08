package fr.norsys.booksapi.repository;

import fr.norsys.booksapi.entity.User;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserReppository extends JpaRepository<User, Integer> {
    User findUserByName(String name);
}
