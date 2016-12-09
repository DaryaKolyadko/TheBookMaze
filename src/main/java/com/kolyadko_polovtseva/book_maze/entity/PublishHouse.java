package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "publish_house")
public class PublishHouse implements Serializable {
    @Id
    @Column(name="id_publish_house")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublishHouse;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "publishHouse")
    private Set<Book> books;

    public Integer getIdPublishHouse() {
        return idPublishHouse;
    }

    public void setIdPublishHouse(Integer idPublishHouse) {
        this.idPublishHouse = idPublishHouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublishHouse)) return false;

        PublishHouse that = (PublishHouse) o;

        if (!idPublishHouse.equals(that.idPublishHouse)) return false;
        if (!name.equals(that.name)) return false;
        return books != null ? books.equals(that.books) : that.books == null;

    }

    @Override
    public int hashCode() {
        int result = idPublishHouse.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}