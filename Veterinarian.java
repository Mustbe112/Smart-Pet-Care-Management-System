/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
public class Veterinarian {
    private final String id;
    private String name;
    private String specialty;

    public Veterinarian(String id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    @Override

    public String toString() {
        return String.format(
            "Veterinarian\n" +
            "----------------------------------\n" +
            "Vet ID      : %s\n" +
            "Name        : %s\n" +
            "Specialty   : %s\n",
            id, name, specialty
        );
    }

}


