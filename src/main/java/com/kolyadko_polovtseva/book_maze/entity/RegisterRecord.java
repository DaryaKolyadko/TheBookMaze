package com.kolyadko_polovtseva.book_maze.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by DaryaKolyadko on 26.11.2016.
 */
@Entity
@Table(name = "register")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRecord implements Serializable {
    @Id
    @Column(name = "id_register")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRegister;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_book_id")
    private LibraryBook libraryBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login")
    private User user;

    @Column(name = "reserve_date")
    private Date reserveDate;

    @Column(name = "return_deadline")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RegisterRecord)) return false;

        RegisterRecord that = (RegisterRecord) o;

        if (idRegister != null ? !idRegister.equals(that.idRegister) : that.idRegister != null) return false;
        if (libraryBook != null ? !libraryBook.equals(that.libraryBook) : that.libraryBook != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (reserveDate != null ? !reserveDate.equals(that.reserveDate) : that.reserveDate != null) return false;
        return returnDeadline != null ? returnDeadline.equals(that.returnDeadline) : that.returnDeadline == null;

    }

    @Override
    public int hashCode() {
        int result = idRegister != null ? idRegister.hashCode() : 0;
        result = 31 * result + (libraryBook != null ? libraryBook.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (reserveDate != null ? reserveDate.hashCode() : 0);
        result = 31 * result + (returnDeadline != null ? returnDeadline.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RegisterRecord{" +
                "idRegister=" + idRegister +
                ", libraryBook=" + libraryBook +
                ", user=" + user +
                ", reserveDate=" + reserveDate +
                ", returnDeadline=" + returnDeadline +
                '}';
    }
}