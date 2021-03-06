package com.kolyadko_polovtseva.book_maze.dao;

import com.kolyadko_polovtseva.book_maze.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by DaryaKolyadko on 09.12.2016.
 */
@Component("userRepository")
@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findUserByLoginAndPassword(String login, String password);

    List<User> findAll();
}