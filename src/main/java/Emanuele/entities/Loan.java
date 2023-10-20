package Emanuele.entities;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Prestito")
public class Loan {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_badgeNumber", nullable = false) // CONTROLLA ASSOCIAZIONE
    private User user;
    @OneToOne
    @JoinColumn(name = "PublicationElement_isbn", nullable = false)
    private PublicationElement publicationElement; //
    private LocalDate loanStartingDate;
    private LocalDate loanDeadlineReturningDate = setLoanDeadlineReturningDate(loanStartingDate);
    @Nullable
    private LocalDate loanReturningDate;


    public Loan() {}

    public Loan(User user, PublicationElement publicationElement, LocalDate loanStartingDate) {
        this.user = user;
        this.publicationElement = publicationElement;
        loanStartingDate = loanStartingDate;
    }

    public Loan(LocalDate loanReturningDate) {
        loanReturningDate = loanReturningDate;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getLoanStartingDate() {
        return loanStartingDate;
    }

    public void setLoanStartingDate(LocalDate loanStartingDate) {
        loanStartingDate = loanStartingDate;
    }

    public LocalDate getLoanDeadlineReturningDate() {
        return loanDeadlineReturningDate;
    }


    public LocalDate getLoanReturningDate() {
        return loanReturningDate;
    }

    public void setLoanReturningDate(LocalDate loanReturningDate) {
        loanReturningDate = loanReturningDate;
    }

    public PublicationElement getPublicationElement() {
        return publicationElement;
    }

    public void setPublicationElement(PublicationElement publicationElement) {
        this.publicationElement = publicationElement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BookLoan{" +
                "id=" + id +
                ", user=" + user +
                ", publicationElement=" + publicationElement +
                ", LoanStartingDate=" + loanStartingDate +
                ", LoanDeadlineReturningDate=" + loanDeadlineReturningDate +
                '}';
    }

    // METODO CHE AUTOMATIZZA SCADENZA CONSEGNA A 30 GG DALLA DATA DI RITIRO
    public LocalDate setLoanDeadlineReturningDate(LocalDate loanStartingDate) {
       return loanStartingDate.plusDays(30);
    }
}
