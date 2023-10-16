package com.example.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner buddyInfoDemo(BuddyInfoRepository repository) {
		return (args) -> {
			// save buddies
			repository.save(new BuddyInfo("John", "111 Bronson Ave", "6131234567"));
			repository.save(new BuddyInfo("John", "222 Bronson Ave", "6131234568"));
			repository.save(new BuddyInfo("Mary", "333 Bronson Ave", "6131234569"));

			// fetch all buddies
			log.info("Buddies found with findAll():");
			log.info("-----------------------------");
			for (BuddyInfo buddy : repository.findAll()) {
				log.info(buddy.toString());
			}
			log.info("");

			// fetch buddy by ID
			BuddyInfo buddy = repository.findById(1L);
			log.info("Buddy found with findById(1L):");
			log.info("------------------------------");
			log.info(buddy.toString());
			log.info("");

			// fetch buddies by name
			log.info("Buddy found with findByName('John'):");
			log.info("------------------------------------");
			repository.findByName("John").forEach(john -> {
				log.info(john.toString());
			});
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner addressBookDemo(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
		return (args) -> {

			// create address books
			AddressBook addressBook1 = new AddressBook();
			addressBook1.addBuddy(new BuddyInfo("John", "111 Bronson Ave", "6131234567"));
			addressBook1.addBuddy(new BuddyInfo("John", "222 Bronson Ave", "6131234568"));
			addressBook1.addBuddy(new BuddyInfo("Mary", "333 Bronson Ave", "6131234569"));

			AddressBook addressBook2 = new AddressBook();
			addressBook2.addBuddy(new BuddyInfo("Jim", "444 Bronson Ave", "6131234577"));
			addressBook2.addBuddy(new BuddyInfo("Jackie", "555 Bronson Ave", "6131234578"));
			addressBook2.addBuddy(new BuddyInfo("Jamie", "666 Bronson Ave", "6131234579"));

			// save buddies
			addressBookRepository.save(addressBook1);
			addressBookRepository.save(addressBook2);

			// fetch all buddies
			log.info("AddressBooks found with findAll():");
			log.info("----------------------------------");
			for (AddressBook addressBook : addressBookRepository.findAll()) {
				log.info(addressBook.toString());
			}
			log.info("");

			// fetch buddy by ID
			AddressBook addressBook = addressBookRepository.findById(1L);
			log.info("AddressBook found with findById(1L):");
			log.info("------------------------------");
			log.info(addressBook.toString());
			log.info("");
		};
	}
}
