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
import model.Dog;

import java.util.List;
import java.util.stream.Collectors;

public class PetService {
    private final Database db;
    public PetService(Database db) { this.db = db; }

    public List<Dog> findDogsByBreed(String breed) {
        return db.getAllPets().stream()
                .filter(p -> p instanceof Dog)
                .map(p -> (Dog) p)
                .filter(d -> d.getBreed().equalsIgnoreCase(breed))
                .collect(Collectors.toList());
    }

    // wildcard usage example method
    public void printPetNames(List<? extends model.Pet> pets) {
        pets.forEach(p -> System.out.println(p.getName() + " (" + p.getClass().getSimpleName() + ")"));
    }
}
