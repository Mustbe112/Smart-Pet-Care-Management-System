/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author winlw
 */

import db.Database;
import model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmentService {
    private final Database db;

    public AppointmentService(Database db) {
        this.db = db;
    }

    // Book an appointment
    public Appointment bookAppointment(String ownerId, String petId, String vetId, String serviceId, LocalDateTime when) {
        Owner owner = db.findOwnerById(ownerId);
        Pet pet = db.findPetById(petId);
        Veterinarian vet = db.findVetById(vetId);
        Service svc = db.getAllServices().stream().filter(s -> s.getId().equals(serviceId)).findFirst().orElse(null);

        if (owner == null || pet == null || vet == null || svc == null) {
            throw new IllegalArgumentException("Invalid ids for booking appointment");
        }

        String id = utils.IdGenerator.generateId("A");
        Appointment a = new Appointment(id, pet, owner, vet, svc, when);
        db.saveAppointment(a);
        return a;
    }

    public List<Appointment> getAll() { return db.getAllAppointments(); }

    // find by predicate using lambda passed in
    public List<Appointment> findBy(Predicate<Appointment> predicate) {
        return db.getAllAppointments().stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Appointment> findScheduled() {
        return findBy(a -> a.getStatus() == Appointment.Status.SCHEDULED);
    }
}



