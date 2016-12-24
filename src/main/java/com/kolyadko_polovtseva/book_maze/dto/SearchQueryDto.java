package com.kolyadko_polovtseva.book_maze.dto;

/**
 * Created by DaryaKolyadko on 23.12.2016.
 */
public class SearchQueryDto {
    private String name;
    private String author;
    private String category;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}