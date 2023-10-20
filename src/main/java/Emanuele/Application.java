package Emanuele;

import Emanuele.entities.Book;
import Emanuele.entities.Magazine;
import Emanuele.entities.PublicationElement;
import Emanuele.entities.User;
import Emanuele.entities.dao.LoanDAO;
import Emanuele.entities.dao.PublicationElementDAO;
import Emanuele.entities.dao.UserDAO;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import java.time.LocalDate;

import static Emanuele.utils.JpaUtil.getEntityManagerFactory;

public class Application {
    public static void main(String[] args) {
        EntityManager entityManager = getEntityManagerFactory().createEntityManager();

        try{

            PublicationElementDAO ed = new PublicationElementDAO(entityManager);
            UserDAO ud = new UserDAO(entityManager);
            LoanDAO ld = new LoanDAO(entityManager);

            Faker faker = new Faker();

            User user1 = new User(faker.name(), faker.name(), faker.date() );
            User user2 = new User(faker.name(), faker.name(), faker.date() );
            User user3 = new User(faker.name(), faker.name(), faker.date() );
            ud.save(user1);
            ud.save(user2);
            ud.save(user3);

            Book book1 = new Book();

            Magazine magazine1 = new Magazine(faker.t);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            entityManager.close();
            getEntityManagerFactory().close();
        }
    }
    }

}
