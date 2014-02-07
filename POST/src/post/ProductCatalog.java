/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class is for initialization the product catalog
 *
 * @author terrywong
 */
public class ProductCatalog {

    private BufferedReader source;
    private static int lineno = -1;
    private String nextLine, desc, upc;
    private double price;
    private static ArrayList<String> savedProductFile;
    private static ArrayList<Product> productCatalog;

    /**
     * Construct a new product catalog.
     *
     * @param productFile
     */
    public ProductCatalog(String productFile) throws IOException {
        System.out.println("User Directory: " + System.getProperty("user.dir"));
        System.out.println("Product Catalog File: " + productFile);
        source = new BufferedReader(new FileReader(productFile));
        if (savedProductFile == null) {
            savedProductFile = new ArrayList<>();
        }
        if (productCatalog == null) {
            productCatalog = new ArrayList<>();
        }
    }

    void close() {
        try {
            source.close();
        } catch (IOException e) {
            System.err.println("**** " + e);
        }
    }

    /**
     * Load all the available products from file.
     */
    public void loadProducts() {
        try {
            do {
                lineno++;
                nextLine = source.readLine(); //reads a line from the productFile
                if (nextLine != null) {
                    StringTokenizer st = new StringTokenizer(nextLine);
                    savedProductFile.add(nextLine);
                    if (st.hasMoreTokens()) {
                        upc = st.nextToken();
                    } else {
                        throw new IOException();
                    }
                    if (st.hasMoreTokens()) {
                        desc = st.nextToken();
                    } else {
                        throw new IOException();
                    }
                    if (st.hasMoreTokens()) {
                        price = Double.valueOf(st.nextToken());
                    } else {
                        throw new IOException();
                    }
                    addProduct(desc, price, upc);
                }

            } while (nextLine != null);
        } catch (IOException e) {
            System.err.println("**** Invalid Product Catalog Database **** " + e);

        }
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }

    /**
     * Find a product by its UPC and return null if not found.
     */
    public Product getProduct(String upc) {
        for (Product p : productCatalog) {
            if (upc.equals(p.getUPC())) {
                return p;
            }
        }
        return null;
    }

    /**
     * Add a product to the product catalog. IOException is thrown if UPC entry
     * is invalid.
     *
     * @param desc
     * @param price
     * @param upc
     * @throws java.io.IOException
     */
    public void addProduct(String desc, double price, String upc) throws IOException {
        if (getProduct(upc) == null) {
            Product product = new Product(desc, price, upc);
            productCatalog.add(product);
        } else {
            throw new IOException("**** UPC already exists! ****");
        }
    }

    public static int getLineno() {
        return lineno;
    }

    public static ArrayList<String> getSavedProductFile() {
        return savedProductFile;
    }

    @Override
    public String toString() {
        String productFileOutput = "";
        for (String line : savedProductFile) {
            productFileOutput += line + "\n";
        }
        return productFileOutput;
    }
}
