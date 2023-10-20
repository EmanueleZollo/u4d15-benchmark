package Emanuele.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Elemento pubblicato")
public abstract class PublicationElement {

    @Id
    private long isbn;
    private String title;
    private LocalDate publicationYear;
    private int pageNumber;

    public PublicationElement() {}

    public PublicationElement(long isbn, String title, LocalDate publicationYear, int pageNumber) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumber = pageNumber;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        return " " +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
