/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.io.IOException;

/**
 * This class describes a product.
 *
 * @author terrywong
 */
public class Product {

    private String description, UPC;
    private double price;
    private static final int UPC_LENGTH = 4;

    /**
     * Construct a new product. Check for valid UPC entry.
     *
     * @param desc
     * @param pc
     * @param upc
     */
    public Product(String desc, double pc, String upc) {
        description = desc;
        price = pc;
        try {
            if (String.valueOf(upc).length() != UPC_LENGTH) {
                throw new IOException();
            }
            UPC = upc;
        } catch (IOException e) {
            System.err.println("**** Invalid UPC Entry **** " + e);
        }
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double p) {
        price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setUPC(String upc) {
        try {
            if (upc.length() != UPC_LENGTH) {
                throw new IOException();
            }
            UPC = upc;
        } catch (IOException e) {
            System.err.println("**** Invalid UPC Entry **** " + e);
        }
    }

    public String getUPC() {
        return UPC;
    }
}
