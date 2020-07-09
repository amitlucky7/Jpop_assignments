package com.epam.libraryservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_description")
    private String bookDescription;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdOn;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "last_modified_on")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastModifiedOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public Book bookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public Book bookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
        return this;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book authorName(String authorName) {
        this.authorName = authorName;
        return this;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Book createdBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public Book createdOn(LocalDate createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public Book lastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDate getLastModifiedOn() {
        return lastModifiedOn;
    }

    public Book lastModifiedOn(LocalDate lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
        return this;
    }

    public void setLastModifiedOn(LocalDate lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        return id != null && id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", bookName='" + getBookName() + "'" +
                ", bookDescription='" + getBookDescription() + "'" +
                ", authorName='" + getAuthorName() + "'" +
                ", createdBy='" + getCreatedBy() + "'" +
                ", createdOn='" + getCreatedOn() + "'" +
                ", lastModifiedBy='" + getLastModifiedBy() + "'" +
                ", lastModifiedOn='" + getLastModifiedOn() + "'" +
                "}";
    }
}
