/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
import java.util.ArrayList;
import java.util.List;

public class Owner {
    private final String id;
    private String name;
    private String email;
    private final List<Pet> pets = new ArrayList<>();

    public Owner(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void addPet(Pet p) { pets.add(p); }
    public List<Pet> getPets() { return new ArrayList<>(pets); } // defensive copy

    @Override

    public String toString() {
        return String.format(
            "Owner\n" +
            "----------------------------------\n" +
            "Owner ID    : %s\n" +
            "Name        : %s\n" +
            "Email       : %s\n" +
            "Total Pets  : %d\n",
            id, name, email, pets.size()
        );
    }

}


