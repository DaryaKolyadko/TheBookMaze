package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "library_book")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LibraryBook implements Serializable {
    @Id
    @Column(name = "id_library_book")
    private Integer idLibraryBook;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "libraryBook")
    private Set<RegisterRecord> registerRecords;

    public Integer getIdLibraryBook() {
        return idLibraryBook;
    }

    public void setIdLibraryBook(Integer idLibraryBook) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryBook)) return false;

        LibraryBook that = (LibraryBook) o;

        if (idLibraryBook != null ? !idLibraryBook.equals(that.idLibraryBook) : that.idLibraryBook != null)
            return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;
        return registerRecords != null ? registerRecords.equals(that.registerRecords) : that.registerRecords == null;

    }

    @Override
    public int hashCode() {
        int result = idLibraryBook != null ? idLibraryBook.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (registerRecords != null ? registerRecords.hashCode() : 0);
        return result;
    }
}