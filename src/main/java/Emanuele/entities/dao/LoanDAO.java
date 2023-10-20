package Emanuele.entities.dao;


import Emanuele.entities.Book;
import Emanuele.entities.Loan;
import Emanuele.entities.PublicationElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoanDAO {
    private final EntityManager entityManager;

    public LoanDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = entityManager.getTransaction();
        /* INIZIO LA TRANSAZIONE*/
        transaction.begin();
        entityManager.persist(loan);
        transaction.commit();
        System.out.println("Il prestito è stato correttamente inserito");
    }

    public Loan findById(long id) {
        return entityManager.find(Loan.class, id);
    }

    public void delete(long id) {
        Loan loanToBeDeleted = entityManager.find(Loan.class, id);

        if (loanToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(loanToBeDeleted);
            transaction.commit();
            System.out.println("Questo prestito è stato cancellato con successo!");
        } else {
            System.out.println("Prestito non presente nel database");
        }
    }

    public List<Loan> findPublicationElementLentByUsers() {
        TypedQuery<Loan> getAllQuery = entityManager.createQuery("SELECT l.user_badgeNumber FROM Loan l", Loan.class);
        return getAllQuery.getResultList();
    }


    public List<Loan> findPublicationElementLentNotReturned() {
        TypedQuery<Loan> getAllQuery = entityManager.createQuery("SELECT l FROM Loan l " +
                "WHERE LocaleDate.now > l.loanDeadlineReturningDate" +
                " AND l.loanReturningDate = null", Loan.class);
        return getAllQuery.getResultList();
    }

}
