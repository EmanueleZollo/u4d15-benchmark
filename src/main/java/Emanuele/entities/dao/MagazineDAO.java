package Emanuele.entities.dao;

import Emanuele.entities.Book;
import Emanuele.entities.Magazine;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class MagazineDAO {
    private final EntityManager entityManager;

    public MagazineDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void save (Magazine magazine) {
        EntityTransaction transaction = entityManager.getTransaction();

        /* INIZIO LA TRANSAZIONE*/
        transaction.begin();

        /*AGGIUNGO AL PERSISTENCE CONTEXT ---- no salvataggio*/
        entityManager.persist(magazine);

        /* SALVO NUOVA RIGA DEL DB */
        transaction.commit();
        System.out.println("La rivista è stata correttamente salvata");

    }

    public Magazine findById (long id) {
        return entityManager.find(Magazine.class, id);
    }

    public void delete (long id) {
        Magazine magazineToBeDeleted = entityManager.find(Magazine.class, id);

        if (magazineToBeDeleted != null) {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.remove(magazineToBeDeleted);
            transaction.commit();
            System.out.println("Questa rivista è stata cancellata con successo!");
        } else {
            System.out.println("Rivista non presente nel database");
        }
    }
}
