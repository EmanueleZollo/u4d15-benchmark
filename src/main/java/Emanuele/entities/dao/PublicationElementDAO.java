package Emanuele.entities.dao;

import Emanuele.entities.Book;
import Emanuele.entities.Magazine;
import Emanuele.entities.PublicationElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PublicationElementDAO {
    private final EntityManager em;

    public PublicationElementDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PublicationElement pe) {
        EntityTransaction transaction = em.getTransaction();
        // 1. Inizio la transazione
        transaction.begin();
        // 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(pe);
        // 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella
        transaction.commit();
        System.out.println("Nuova pubblicazione salvata correttamente");
    }

    public void findByIdAndDelete(long isbn) {

        // 1. Faccio una find per cercare la pubblicazione
        PublicationElement publicationFound = em.find(PublicationElement.class, isbn);

        if (publicationFound != null) {
            // 2. Se c'è, la elimino
            // 2.1 Ottengo la transazione
            EntityTransaction transaction = em.getTransaction();
            // 2.2 Faccio partire la transazione
            transaction.begin();
            // 2.3 Rimuovo l'oggetto dal persistence context
            em.remove(publicationFound);
            // 2.4 Faccio il commit della transazione per persistere a db l'operazione
            transaction.commit();
            System.out.println("La pubblicazione è stato cancellata correttamente");
        } else {
            System.err.println("La pubblicazione con l'isbn " + isbn + " non è stata trovata");
        }
    }

    public PublicationElement findByISBN(long isbn) {
        return em.find(PublicationElement.class, isbn);
    }


    public List<PublicationElement> findPublicationElementByYear() {
        // SELECT * FROM PublicationElement
        TypedQuery<PublicationElement> getAllQuery = em.createQuery("SELECT pe.publicationYear FROM PublicationElement pe", PublicationElement.class);
        return getAllQuery.getResultList();
    }


    public List<Book> findPublicationElementByAuthor() {
        TypedQuery<Book> getAllQuery = em.createQuery("SELECT b.author FROM Book b", Book.class);
        return getAllQuery.getResultList();
    }

    public List<PublicationElement> findPublicationElementByTitle() {
        // SELECT * FROM PublicationElement
        TypedQuery<PublicationElement> getAllQuery = em.createQuery("SELECT pe.title FROM PublicationElement pe " +
                "WHERE LOWER(pe.title) LIKE CONCAT('%', LOWER(?) , '%' )", PublicationElement.class);
        return getAllQuery.getResultList();
    }


}
