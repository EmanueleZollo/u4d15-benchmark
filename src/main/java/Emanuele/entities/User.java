package Emanuele.entities;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Name;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Utente")
public class User {
    @Id
    @GeneratedValue
    private long badgeNumber;
    private String name;
    private String surname;
    private LocalDate birthday;

    @OneToMany(mappedBy = "user")
    private List<Loan> loans;

    public User(Name name, Name named, DateAndTime date) {}

    public User(String name, String surname, LocalDate birthday) {
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
