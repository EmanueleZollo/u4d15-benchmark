package Emanuele.entities.dao;

import Emanuele.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookDAO {
    private final EntityManager entityManager;

    public BookDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Book book) {
        EntityTransaction transaction = entityManager.getTransaction();

       /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(book);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("La persona è stata correttamente salvata");

    }

    public Book findById (long id) {
        return entityManager.find(Book.class, id);
    }

    public void delete (long id) {
        Book bookToBeDeleted = entityManager.find(Book.class, id);

        if (bookToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(bookToBeDeleted);
            transaction.commit();
            System.out.println("Questo libro è stato cancellato con successo!");
        } else {
            System.out.println("Libro non presente nel database");
        }
    }
}
