/*
 * This class describes a product.
 */
package post;

import java.io.IOException;

/**
 *
 * @author terrywong
 */
public class Product {

    private String description, UPC;
    private double price;
    private static final int UPC_LENGTH = 4;

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
