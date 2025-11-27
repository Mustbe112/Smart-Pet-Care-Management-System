/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
public abstract class Pet {
    private final String id;
    private String name;
    private int age;
    private double weight;
    private final MedicalRecord medicalRecord;

    public Pet(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.medicalRecord = new MedicalRecord();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    // abstract method to be implemented by subclasses (polymorphism)
    public abstract void makeSound();

    @Override

    public String toString() {
        return String.format(
            "%s\n" +
            "----------------------------------\n" +
            "Pet ID      : %s\n" +
            "Name        : %s\n" +
            "Age         : %d\n",
            this.getClass().getSimpleName(),
            id, name, age
        );
    }

}

