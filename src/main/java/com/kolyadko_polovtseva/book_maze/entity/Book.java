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
@Table(name = "book")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book implements Serializable {
    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

    @Column(name = "name")
    private String name;

    @Column(name = "page_num")
    private Integer pageNum;

    @Column(name = "publish_year")
    private Integer publishYear;

    @Column(name = "description")
    private String description;

    @Column(name = "ebook_url")
    private String ebookUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "publish_house_id")
    private PublishHouse publishHouse;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "book")
    private Set<LibraryBook> libraryBooks;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", joinColumns = {
            @JoinColumn(name = "book_id_book", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "author_id_author",
                    nullable = false)})
    private Set<Author> authors;

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEbookUrl() {
        return ebookUrl;
    }

    public void setEbookUrl(String ebookUrl) {
        this.ebookUrl = ebookUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PublishHouse getPublishHouse() {
        return publishHouse;
    }

    public void setPublishHouse(PublishHouse publishHouse) {
        this.publishHouse = publishHouse;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<LibraryBook> getLibraryBooks() {
        return libraryBooks;
    }

    public void setLibraryBooks(Set<LibraryBook> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (idBook != null ? !idBook.equals(book.idBook) : book.idBook != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (pageNum != null ? !pageNum.equals(book.pageNum) : book.pageNum != null) return false;
        if (publishYear != null ? !publishYear.equals(book.publishYear) : book.publishYear != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (ebookUrl != null ? !ebookUrl.equals(book.ebookUrl) : book.ebookUrl != null) return false;
        if (imageUrl != null ? !imageUrl.equals(book.imageUrl) : book.imageUrl != null) return false;
        if (category != null ? !category.equals(book.category) : book.category != null) return false;
        if (publishHouse != null ? !publishHouse.equals(book.publishHouse) : book.publishHouse != null) return false;
        if (libraryBooks != null ? !libraryBooks.equals(book.libraryBooks) : book.libraryBooks != null) return false;
        return authors != null ? authors.equals(book.authors) : book.authors == null;

    }

//    @Override
//    public int hashCode() {
//        int result = idBook != null ? idBook.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (pageNum != null ? pageNum.hashCode() : 0);
//        result = 31 * result + (publishYear != null ? publishYear.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (ebookUrl != null ? ebookUrl.hashCode() : 0);
//        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
//        result = 31 * result + (category != null ? category.hashCode() : 0);
//        result = 31 * result + (publishHouse != null ? publishHouse.hashCode() : 0);
//        result = 31 * result + (libraryBooks != null ? libraryBooks.hashCode() : 0);
//        result = 31 * result + (authors != null ? authors.hashCode() : 0);
//        return result;
//    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", pageNum=" + pageNum +
                ", publishYear=" + publishYear +
                ", description='" + description + '\'' +
                ", ebookUrl='" + ebookUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                ", publishHouse=" + publishHouse +
                ", libraryBooks=" + libraryBooks +
                ", authors=" + authors +
                '}';
    }
}