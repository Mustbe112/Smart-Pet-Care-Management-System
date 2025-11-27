/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
public class Cat extends Pet {
    private String breed;

    public Cat(String id, String name, int age, String breed) {
        super(id, name, age);
        this.breed = breed;
    }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}



