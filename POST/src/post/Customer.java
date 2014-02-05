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
    private HashMap<Integer, Integer> purchases;

    public Customer(String n) {
        this.purchases = new HashMap();
        name = n;
    }

    public HashMap getPurchases() {
        return purchases;
    }

    public void setPurchases(int upc, int quantity) {
        try {
            if (String.valueOf(upc).length() != UPC_LENGTH) {
                throw new IOException();
            }
            purchases.put(upc, quantity);
        } catch (IOException e) {
            System.out.println("**** Invalid UPC Entry **** " + e);
        }
    }
}
