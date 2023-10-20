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

    public PublicationElement findByISBN(long isbn) {
        return em.find(PublicationElement.class, isbn);
    }

    // DISCRIMINANTE PER DISTINGUERE LIBRI DA RIVISTE???
  /*  public Book findBookByAuthor(long isbn) {
        return em.find(Book.class, isbn);
    }

    public Magazine findMagazineById(long id) {
        return em.find(Magazine.class, id);
    }*/

    public List<PublicationElement> findAll() {
        // SELECT * FROM PublicationElement
        TypedQuery<PublicationElement> getAllQuery = em.createQuery("SELECT pe FROM PublicationElement pe", PublicationElement.class); // Query JPQL
        return getAllQuery.getResultList();
    }

    public List<Book> findAllBooks() {
        // SELECT * FROM PublicationElement WHERE tipo_pubblicazione = 'Libro'
        TypedQuery<Book> getAllQuery = em.createQuery("SELECT b FROM Book b", Book.class); // Query JPQL
        return getAllQuery.getResultList();
    }

    public List<Magazine> findAllMagazines() {
        // SELECT * FROM PublicationElement WHERE tipo_pubblicazione = 'Rivista'
        TypedQuery<Magazine> getAllQuery = em.createQuery("SELECT m FROM Magazine m", Magazine.class); // Query JPQL
        return getAllQuery.getResultList();
    }

    public List<String> findAllPublicationTitles() {
        // SELECT * FROM PublicationElement WHERE titolo = ''
        TypedQuery<String> getAllQuery = em.createQuery("SELECT pe.title FROM PublicationElement pe", String.class); // Query JPQL
        return getAllQuery.getResultList();
    }

}
