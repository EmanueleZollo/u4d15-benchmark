package Emanuele.entities.dao;

import Emanuele.entities.Book;
import Emanuele.entities.Loan;
import Emanuele.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (User user) {
        EntityTransaction transaction = entityManager.getTransaction();

        /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(user);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("L'utente è stato correttamente inserito");

    }

    public User findById (long id) {
        return entityManager.find(User.class, id);
    }

    public void delete (long id) {
        User userToBeDeleted = entityManager.find(User.class, id);

        if (userToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(userToBeDeleted);
            transaction.commit();
            System.out.println("Questo utente è stato cancellato con successo!");
        } else {
            System.out.println("Utente non presente nel database");
        }
    }
}
