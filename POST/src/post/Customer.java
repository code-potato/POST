/*
 * This class describes a customer.
 */
package post;

import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author terrywong
 */
public class Customer {

    private String name;
    private static final int UPC_LENGTH = 4;
    private HashMap<String, Integer> purchases;

    public Customer(String n) {
        this.purchases = new HashMap();
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        name = nm;
    }

    public HashMap getPurchases() {
        return purchases;
    }

    // Set the upc and quantity pairs of a customer's purchases
    public void setPurchases(String upc, int quantity) {
        try {
            if (upc.length() != UPC_LENGTH) {
                throw new IOException();
            }
            purchases.put(upc, quantity);
        } catch (IOException e) {
            System.err.println("**** Invalid UPC Entry **** " + e);
        }
    }
}
