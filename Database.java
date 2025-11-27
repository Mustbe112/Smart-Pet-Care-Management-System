/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author winlw
 */
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<Owner> owners = new ArrayList<>();
    private final List<Pet> pets = new ArrayList<>();
    private final List<Veterinarian> vets = new ArrayList<>();
    private final List<Service> services = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    // Owners
    public void saveOwner(Owner o) { owners.add(o); }
    public Owner findOwnerById(String id) {
        return owners.stream().filter(o -> o.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Owner> getAllOwners() { return new ArrayList<>(owners); }

    // Pets
    public void savePet(Pet p) { pets.add(p); }
    public Pet findPetById(String id) {
        return pets.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Pet> getAllPets() { return new ArrayList<>(pets); }

    // Vets
    public void saveVet(Veterinarian v) { vets.add(v); }
    public Veterinarian findVetById(String id) {
        return vets.stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Veterinarian> getAllVets() { return new ArrayList<>(vets); }

    // Services
    public void saveService(Service s) { services.add(s); }
    public List<Service> getAllServices() { return new ArrayList<>(services); }

    // Appointments
    public void saveAppointment(Appointment a) { appointments.add(a); }
    public List<Appointment> getAllAppointments() { return new ArrayList<>(appointments); }
}


