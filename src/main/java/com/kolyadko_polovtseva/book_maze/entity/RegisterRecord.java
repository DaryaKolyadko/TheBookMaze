package com.kolyadko_polovtseva.book_maze.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
public class RegisterRecord implements Serializable {
    private Integer idRegister;
    private LibraryBook libraryBook;
    private User user;
    private Date reserveDate;
    private Date returnDeadline;

    public Integer getIdRegister() {
        return idRegister;
    }

    public void setIdRegister(Integer idRegister) {
        this.idRegister = idRegister;
    }

    public LibraryBook getLibraryBook() {
        return libraryBook;
    }

    public void setLibraryBook(LibraryBook libraryBook) {
        this.libraryBook = libraryBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getReturnDeadline() {
        return returnDeadline;
    }

    public void setReturnDeadline(Date returnDeadline) {
        this.returnDeadline = returnDeadline;
    }
}