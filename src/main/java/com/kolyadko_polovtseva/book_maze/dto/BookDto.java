package com.kolyadko_polovtseva.book_maze.dto;

import java.util.List;
import java.util.Set;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
public class BookDto {
    private String idBook;
    private String name;
    private String pageNum;
    private String publishYear;
    private String description;
    private String ebookUrl;
    private String imageUrl;
    private String categoryId;
    private String publishHouseId;
    private Set<String> authorIdList;
    private Set<String> libraryBookIdList;

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
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

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPublishHouseId() {
        return publishHouseId;
    }

    public void setPublishHouseId(String publishHouseId) {
        this.publishHouseId = publishHouseId;
    }

    public Set<String> getAuthorIdSet() {
        return authorIdList;
    }

    public void setAuthorIdSet(Set<String> authorIdList) {
        this.authorIdList = authorIdList;
    }

    public Set<String> getLibraryBookIdSet() {
        return libraryBookIdList;
    }

    public void setLibraryBookIdSet(Set<String> libraryBookIdList) {
        this.libraryBookIdList = libraryBookIdList;
    }
}