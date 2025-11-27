/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author winlw
 */
public class Service {
    private final String id;
    private final String description;
    private final double baseCost;

    public Service(String id, String description, double baseCost) {
        this.id = id;
        this.description = description;
        this.baseCost = baseCost;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }
    public double getBaseCost() { return baseCost; }

    @Override

    public String toString() {
        return String.format(
            "Service\n" +
            "----------------------------------\n" +
            "Service ID  : %s\n" +
            "Description : %s\n" +
            "Base Cost   : $ %.2f\n",
            id, description, baseCost
        );
    }

}


