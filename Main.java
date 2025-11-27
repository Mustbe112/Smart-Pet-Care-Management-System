package app;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author winlw
 */
import db.Database;
import model.*;
import services.AppointmentService;
import services.PetService;
import utils.IdGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Database db = new Database();
    private static final AppointmentService apptService = new AppointmentService(db);
    private static final PetService petService = new PetService(db);

    public static void main(String[] args) {
        seedSampleData();
        menuLoop();
    }

    // Sample default data
    private static void seedSampleData() {
        Owner alice = new Owner(IdGenerator.generateId("O"), "Alice", "alice@example.com");
        db.saveOwner(alice);

        Veterinarian vet = new Veterinarian(IdGenerator.generateId("V"), "Dr. Lee", "General");
        db.saveVet(vet);

        Service checkup = new Service(IdGenerator.generateId("S"), "General Checkup", 30.0);
        db.saveService(checkup);
    }

    // Main menu loop
    private static void menuLoop() {
        while (true) {
            System.out.println("\n==============================================");
            System.out.println("      SMART PET CARE MANAGEMENT SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Owner");
            System.out.println("2. Add Pet");
            System.out.println("3. Make Appointment");
            System.out.println("4. List Appointments");
            System.out.println("5. Pet Sounds");
            System.out.println("6. Exit System");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": addOwner(); break;
                case "2": addPet(); break;
                case "3": makeAppointment(); break;
                case "4": listAppointments(); break;
                case "5": petSounds(); break;
                case "6":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Add owner
    private static void addOwner() {
        System.out.println("\n--- Add Owner ---");
        System.out.print("Enter owner name: ");
        String name = scanner.nextLine();

        System.out.print("Enter owner email: ");
        String email = scanner.nextLine();

        Owner owner = new Owner(IdGenerator.generateId("O"), name, email);
        db.saveOwner(owner);

        System.out.println("Owner added: " + owner);
    }

    // Add pet
    private static void addPet() {
        System.out.println("\n--- Add Pet ---");

        if (db.getAllOwners().isEmpty()) {
            System.out.println("No owners found. Add an owner first.");
            return;
        }

        System.out.println("Select owner:");
        for (Owner o : db.getAllOwners()) {
            System.out.println(o.getId() + " - " + o.getName());
        }
        System.out.print("Owner ID: ");
        String ownerId = scanner.nextLine();

        Owner owner = db.findOwnerById(ownerId);
        if (owner == null) {
            System.out.println("Invalid Owner ID!");
            return;
        }

        System.out.print("Pet name: ");
        String petName = scanner.nextLine();

        System.out.print("Pet age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Pet type: 1) Dog  2) Cat");
        System.out.print("Choose: ");
        String type = scanner.nextLine();

        Pet pet = null;
        String id = IdGenerator.generateId("P");

        if (type.equals("1")) {
            System.out.print("Dog breed: ");
            String breed = scanner.nextLine();
            pet = new Dog(id, petName, age, breed);
        } else if (type.equals("2")) {
            System.out.print("Cat breed: ");
            String breed = scanner.nextLine();
            pet = new Cat(id, petName, age, breed);
        } else {
            System.out.println("Invalid type!");
            return;
        }

        owner.addPet(pet);
        db.savePet(pet);

        System.out.println("Pet added: " + pet);
    }

    // Make appointment
    private static void makeAppointment() {
        System.out.println("\n--- Make Appointment ---");

        if (db.getAllOwners().isEmpty() || db.getAllPets().isEmpty()) {
            System.out.println("Add an owner and a pet first.");
            return;
        }

        System.out.println("Select Owner:");
        db.getAllOwners().forEach(o -> System.out.println(o.getId() + " : " + o.getName()));
        System.out.print("Owner ID: ");
        String ownerId = scanner.nextLine();

        System.out.println("Select Pet:");
        db.getAllPets().forEach(p -> System.out.println(p.getId() + " : " + p.getName()));
        System.out.print("Pet ID: ");
        String petId = scanner.nextLine();

        System.out.println("Select Veterinarian:");
        db.getAllVets().forEach(v -> System.out.println(v.getId() + " : " + v.getName()));
        System.out.print("Vet ID: ");
        String vetId = scanner.nextLine();

        System.out.println("Select Service:");
        db.getAllServices().forEach(s -> System.out.println(s.getId() + " : " + s.getDescription()));
        System.out.print("Service ID: ");
        String serviceId = scanner.nextLine();

        try {
            Appointment a = apptService.bookAppointment(
                    ownerId, petId, vetId, serviceId,
                    LocalDateTime.now().plusDays(1)
            );
            System.out.println("Appointment booked: " + a);
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }

    // List appointments
    private static void listAppointments() {
        System.out.println("\n--- Appointments ---");
        List<Appointment> list = apptService.getAll();

        if (list.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        list.forEach(System.out::println);
    }

    // Pet sounds demonstration
    private static void petSounds() {
        System.out.println("\n--- Pet Sounds ---");
        List<model.Pet> pets = db.getAllPets();

        if (pets.isEmpty()) {
            System.out.println("No pets available.");
            return;
        }

        pets.forEach(Pet::makeSound);
    }
}


