package Emanuele.entities;

import com.sun.istack.Nullable;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate LoanStartingDate;
    private LocalDate LoanDeadlineReturningDate;
    @Nullable
    private LocalDate LoanReturningDate;


    public Loan() {}

    public Loan(User user, PublicationElement publicationElement, LocalDate loanStartingDate) {
        this.user = user;
        this.publicationElement = publicationElement;
        LoanStartingDate = loanStartingDate;
    }

    public Loan(LocalDate loanReturningDate) {
        LoanReturningDate = loanReturningDate;
    }

    public UUID getId() {
        return id;
    }


    public LocalDate getLoanStartingDate() {
        return LoanStartingDate;
    }

    public void setLoanStartingDate(LocalDate loanStartingDate) {
        LoanStartingDate = loanStartingDate;
    }

    public LocalDate getLoanDeadlineReturningDate() {
        return LoanDeadlineReturningDate;
    }

    public void setLoanDeadlineReturningDate(LocalDate loanDeadlineReturningDate) {
        LoanDeadlineReturningDate = loanDeadlineReturningDate;
    }

    public LocalDate getLoanReturningDate() {
        return LoanReturningDate;
    }

    public void setLoanReturningDate(LocalDate loanReturningDate) {
        LoanReturningDate = loanReturningDate;
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
                ", LoanStartingDate=" + LoanStartingDate +
                ", LoanDeadlineReturningDate=" + LoanDeadlineReturningDate +
                '}';
    }
}
