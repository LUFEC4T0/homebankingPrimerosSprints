package com.mindhub.homebanking.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
   private String firstName;
    private String lastName;

    private String email;


    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
//   @JsonManagedReference
    private List<Account> accounts= new ArrayList<>();
    public Client() { }



    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount (Account account){
        if ((accounts == null)){
            accounts = new ArrayList<>();
        }
        account.setClient(this);
        accounts.add(account);
    }



    @Override
    public String toString() {
        return
         "Client{" +
                "id= " + id +
                ", Name= " + firstName + ' ' + lastName + "\n" +
                ", email='" + email + "\n" +
                ", Accounts= "+ accounts+
                '}';
    }
}
