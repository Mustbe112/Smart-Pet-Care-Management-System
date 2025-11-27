/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
import java.time.LocalDateTime;

public class Appointment {
    public enum Status { SCHEDULED, COMPLETED, CANCELLED }

    private final String id;
    private final Pet pet;
    private final Owner owner;
    private final Veterinarian vet;
    private final Service service;
    private final LocalDateTime dateTime;
    private Status status;

    public Appointment(String id, Pet pet, Owner owner, Veterinarian vet, Service service, LocalDateTime dateTime) {
        this.id = id;
        this.pet = pet;
        this.owner = owner;
        this.vet = vet;
        this.service = service;
        this.dateTime = dateTime;
        this.status = Status.SCHEDULED;
    }
    public double calculateTotalCost() {
    // Add more cost logic later if needed (tax, extra charges, etc.)
    return service.getBaseCost();
    }


    public String getId() { return id; }
    public Pet getPet() { return pet; }
    public Owner getOwner() { return owner; }
    public Veterinarian getVet() { return vet; }
    public Service getService() { return service; }
    public LocalDateTime getDateTime() { return dateTime; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    @Override


    public String toString() {
        return String.format(
            "\n=====================================================\n" +
            "                 PET CLINIC APPOINTMENT RECEIPT\n" +
            "=====================================================\n\n" +

            "APPOINTMENT INFORMATION\n" +
            "-----------------------------------------------------\n" +
            "Appointment ID : %s\n" +
            "Date & Time    : %s\n" +
            "Status         : %s\n\n" +

            "OWNER INFORMATION\n" +
            "-----------------------------------------------------\n" +
            "Owner ID       : %s\n" +
            "Owner Name     : %s\n" +
            "Owner Email    : %s\n\n" +

            "PET INFORMATION\n" +
            "-----------------------------------------------------\n" +
            "Pet ID         : %s\n" +
            "Pet Name       : %s\n" +
            "Pet Type       : %s\n" +
            "Pet Age        : %d\n\n" +

            "VETERINARIAN DETAILS\n" +
            "-----------------------------------------------------\n" +
            "Vet ID         : %s\n" +
            "Vet Name       : %s\n" +
            "Specialty      : %s\n\n" +

            "SERVICE DETAILS\n" +
            "-----------------------------------------------------\n" +
            "Service ID     : %s\n" +
            "Description    : %s\n" +
            "Base Cost      : RM %.2f\n\n" +

            "TOTAL COST\n" +
            "-----------------------------------------------------\n" +
            "Amount Due     : RM %.2f\n" +
            "=====================================================\n" +
            "        THANK YOU FOR TRUSTING OUR PET CARE!\n" +
            "=====================================================\n",

            id,
            dateTime,
            status,

            owner.getId(),
            owner.getName(),
            owner.getEmail(),

            pet.getId(),
            pet.getName(),
            pet.getClass().getSimpleName(),
            pet.getAge(),

            vet.getId(),
            vet.getName(),
            vet.getSpecialty(),

            service.getId(),
            service.getDescription(),
            service.getBaseCost(),

            calculateTotalCost()
        );
    }


}


