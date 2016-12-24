package com.kolyadko_polovtseva.book_maze.converter;

import com.kolyadko_polovtseva.book_maze.dto.UserDto;
import com.kolyadko_polovtseva.book_maze.entity.User;
import com.kolyadko_polovtseva.book_maze.util.DateUtil;
import org.springframework.stereotype.Component;

/**
 * Created by DaryaKolyadko on 10.12.2016.
 */
@Component
public class UserDtoToUserConverter {
    public User convertFromDto(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setLibraryId(userDto.getLibraryId());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthDate(DateUtil.parse(userDto.getBirthDate()));
        user.setImageUrl(userDto.getImageUrl());
        return user;
    }
}