package com.kolyadko_polovtseva.book_maze.dto;

/**
 * Created by DaryaKolyadko on 12.12.2016.
 */
public class ReserveBookDto {
    private Integer libraryBookId;

    public ReserveBookDto(){}

    public ReserveBookDto(Integer libraryBookId) {
        this.libraryBookId = libraryBookId;
    }

    public Integer getLibraryBookId() {
        return libraryBookId;
    }

    public void setLibraryBookId(Integer libraryBookId) {
        this.libraryBookId = libraryBookId;
    }
}