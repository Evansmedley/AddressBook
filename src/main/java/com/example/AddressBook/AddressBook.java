package com.example.AddressBook;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The AddressBook class represents a collection of BuddyInfo objects and provides
 * methods for adding, removing, and retrieving buddies from the address book.
 */
@Entity
public class AddressBook {

    @Id
    @GeneratedValue()
    private Long id; // The id of the AddressBook.

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies; // The list of buddies stored in the AddressBook.

    /**
     * Default constructor for the AddressBook class.
     */
    public AddressBook() {
        this.buddies = new ArrayList<>();
    }

    /**
     * Get the ID of the AddressBook.
     *
     * @return The ID of the AddressBook.
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param buddy
     */
    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
    }

    /**
     * Get the list of buddies stored in the AddressBook.
     *
     * @return The list of BuddyInfo objects in the AddressBook.
     */
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    /**
     * Set the list of buddies in the AddressBook.
     *
     * @param buddies The list of BuddyInfo objects to set in the AddressBook.
     */
    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "id=" + id +
                ", buddies=" + buddies +
                '}';
    }
}
