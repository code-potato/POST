/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            Integer put = purchases.put(upc, quantity);
        } catch (IOException e) {
            System.out.println("**** Invalid UPC Entry **** " + e);
        }
    }
}
