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
    // If we are going to iterate all list, we should use arraylist
    // rather than using HashMap!!!!!!!!!!!!!!!!!!!!!!!!!
    
    public Customer(String name) {
        this.purchases = new HashMap();
        this.name = name;
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

    public void setPurchases(String upc, int quantity) {
        try {
            if (upc.length() != UPC_LENGTH) {
                throw new IOException();
            }
            purchases.put(upc, quantity);
        } catch (IOException e) {
            System.out.println("**** Invalid UPC Entry **** " + e);
        }
    }
}
