package com.kolyadko_polovtseva.book_maze.util;

import com.kolyadko_polovtseva.book_maze.entity.Author;

import java.util.Set;

public class AuthorUtil {

    public static String toString(Set<Author> authors) {
        String names = "";
        for (Author a : authors) {
            names += a.getFirstName() + " " + a.getLastName() + "\n";
        }
        return names;
    }
}