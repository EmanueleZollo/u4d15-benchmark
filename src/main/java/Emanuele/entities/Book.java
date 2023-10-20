package Emanuele.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Libro")
public class Book extends PublicationElement{
    private String author;
    private String genre;

    public Book(){}

    public Book(long isbn, String title, LocalDate publicationYear, int pageNumber, String author, String genre) {
        super(isbn, title, publicationYear, pageNumber);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" + super.toString() +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                "} ";
    }
}
