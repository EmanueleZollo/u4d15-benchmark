package Emanuele.entities.dao;

import Emanuele.entities.Book;
import Emanuele.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LoanDAO {
    private final EntityManager entityManager;

    public LoanDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Loan loan) {
        EntityTransaction transaction = entityManager.getTransaction();

        /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(loan);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("Il prestito è stato correttamente inserito");

    }

    public Loan findById (long id) {
        return entityManager.find(Loan.class, id);
    }

    public void delete (long id) {
        Book loanToBeDeleted = entityManager.find(Book.class, id);

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
}
