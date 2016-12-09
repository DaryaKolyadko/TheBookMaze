package com.kolyadko_polovtseva.book_maze.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "library_book")
public class LibraryBook implements Serializable {
    @Id
    @Column(name = "id_library_book")
    private String idLibraryBook;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Book book;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "libraryBook")
    private Set<RegisterRecord> registerRecords;

    public String getIdLibraryBook() {
        return idLibraryBook;
    }

    public void setIdLibraryBook(String idLibraryBook) {
        this.idLibraryBook = idLibraryBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<RegisterRecord> getRegisterRecords() {
        return registerRecords;
    }

    public void setRegisterRecords(Set<RegisterRecord> registerRecords) {
        this.registerRecords = registerRecords;
    }
}