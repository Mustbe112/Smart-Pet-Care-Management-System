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

public class MedicalRecord {
    private final List<String> entries = new ArrayList<>();

    public void addEntry(String note) { entries.add(note); }
    public List<String> getEntries() { return new ArrayList<>(entries); }

    public void printEntries() {
        if (entries.isEmpty()) {
            System.out.println("  (no records)");
            return;
        }
        for (String e : entries) System.out.println("  - " + e);
    }
}

