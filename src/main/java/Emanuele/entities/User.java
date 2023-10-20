package Emanuele.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Utente")
public class User {
    @Id
    @GeneratedValue
    private long badgeNumber;
    private String name;
    private String surname;
    private LocalDate birthday;

    public User() {}

    public User(long badgeNumber, String name, String surname, LocalDate birthday) {
        this.badgeNumber = badgeNumber;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public long getBadgeNumber() {
        return badgeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "badgeNumber=" + badgeNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
