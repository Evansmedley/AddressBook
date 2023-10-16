package com.example.AddressBook;

import jakarta.persistence.*;

/**
 * The BuddyInfo class represents information about a buddy, including their name, address, and phone number.
 */
@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue()
    private Long id; // The id of the buddy.
    private String name; // The name of the buddy.
    private String address; // The address of the buddy.
    private String phoneNumber; // The phone number of the buddy

    /**
     * Creates a new instance of BuddyInfo.
     */
    protected BuddyInfo() {
    }

    /**
     * Constructs a new BuddyInfo object with the specified name, address, and phone number.
     *
     * @param name        The name of the buddy.
     * @param address     The address of the buddy.
     * @param phoneNumber The phone number of the buddy.
     */
    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Retrieves the ID of the buddy.
     *
     * @return The ID of the buddy.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Retrieves the name of the buddy.
     *
     * @return The name of the buddy.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the address of the buddy.
     *
     * @return The address of the buddy.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Retrieves the phone number of the buddy.
     *
     * @return The phone number of the buddy.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "BuddyInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
