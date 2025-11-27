/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author winlw
 */
import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger counter = new AtomicInteger(1);

    // prefix e.g. "A" -> A-1, P -> P-2
    public static String generateId(String prefix) {
        return prefix + "-" + counter.getAndIncrement();
    }
}
