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

    private String name, description;
    private double price;
    private int UPC;
    private static final int UPC_LENGTH = 4;

    public Product(String nm, String desc, double p, int upc) {
        name = nm;
        description = desc;
        price = p;
        try {
            if (String.valueOf(upc).length() != UPC_LENGTH) {
                throw new IOException();
            }
            UPC = upc;
        } catch (IOException e) {
            System.out.println("**** Invalid UPC Entry **** " + e);
        }
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getName() {
        return name;
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

    public void setUPC(int upc) {
        try {
            if (String.valueOf(upc).length() != UPC_LENGTH) {
                throw new IOException();
            }
            UPC = upc;
        } catch (IOException e) {
            System.out.println("**** Invalid UPC Entry **** " + e);
        }
    }

    public int getUPC() {
        return UPC;
    }
}
