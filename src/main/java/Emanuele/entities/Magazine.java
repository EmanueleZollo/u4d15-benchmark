package Emanuele.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Rivista")
public class Magazine extends PublicationElement{

    @Enumerated(EnumType.STRING)
    private FrequencyOfPublication frequencyOfPublication;

    public Magazine(){}

    public Magazine(long isbn, String title, LocalDate publicationYear, int pageNumber, FrequencyOfPublication frequencyOfPublication) {
        super(isbn, title, publicationYear, pageNumber);
        this.frequencyOfPublication = frequencyOfPublication;
    }

    public FrequencyOfPublication getFrequencyOfPublication() {
        return frequencyOfPublication;
    }

    @Override
    public String toString() {
        return "Magazine{" + super.toString() +
                "frequencyOfPublication=" + frequencyOfPublication +
                "} ";
    }
}
