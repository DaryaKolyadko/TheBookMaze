package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 25.11.2016.
 */
@Entity
@Table(name = "category")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "password"})
public class Category implements Serializable {
    @Id
    @Column(name = "id_category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategory;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Book> books;

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (idCategory != null ? !idCategory.equals(category.idCategory) : category.idCategory != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (imageUrl != null ? !imageUrl.equals(category.imageUrl) : category.imageUrl != null) return false;
        return books != null ? books.equals(category.books) : category.books == null;

    }

//    @Override
//    public int hashCode() {
//        int result = idCategory != null ? idCategory.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
//        result = 31 * result + (books != null ? books.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "Category{" +
                "idCategory=" + idCategory +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", books=" + books +
                '}';
    }
}