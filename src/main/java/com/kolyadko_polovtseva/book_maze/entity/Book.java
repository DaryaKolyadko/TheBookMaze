package com.kolyadko_polovtseva.book_maze.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "book")
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

        if (!idBook.equals(book.idBook)) return false;
        if (!name.equals(book.name)) return false;
        if (!pageNum.equals(book.pageNum)) return false;
        if (!publishYear.equals(book.publishYear)) return false;
        if (!description.equals(book.description)) return false;
        if (ebookUrl != null ? !ebookUrl.equals(book.ebookUrl) : book.ebookUrl != null) return false;
        if (imageUrl != null ? !imageUrl.equals(book.imageUrl) : book.imageUrl != null) return false;
        if (!category.equals(book.category)) return false;
        if (!publishHouse.equals(book.publishHouse)) return false;
        if (libraryBooks != null ? !libraryBooks.equals(book.libraryBooks) : book.libraryBooks != null) return false;
        return authors.equals(book.authors);

    }

    @Override
    public int hashCode() {
        int result = idBook.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + pageNum.hashCode();
        result = 31 * result + publishYear.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + (ebookUrl != null ? ebookUrl.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + category.hashCode();
        result = 31 * result + publishHouse.hashCode();
        result = 31 * result + (libraryBooks != null ? libraryBooks.hashCode() : 0);
        result = 31 * result + authors.hashCode();
        return result;
    }
}