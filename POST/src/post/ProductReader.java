/*
 * Read the product catalog for initialization
 */
package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author terrywong
 */
public class ProductReader {

    private BufferedReader source;
    private static int lineno = -1;
    private String nextLine, desc, upc;
    private double price;
    private static ArrayList<String> savedProductFile;
    private static ArrayList<Product> productCatalog;

    /**
     * Construct a new ProductReader for a product catalog.
     *
     * @param productFile
     * @exception IOException is thrown if there is an I/O problem
     */
    public ProductReader(String productFile) throws IOException {
        System.out.println("User Directory: " + System.getProperty("user.dir"));
        System.out.println("Product Catalog File: " + productFile);
        source = new BufferedReader(new FileReader(productFile));
        savedProductFile = new ArrayList<>();
        productCatalog = new ArrayList<>();
    }

    void close() {
        try {
            source.close();
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    /**
     * Load all the products from file.
     *
     * @return
     */
    public void loadProducts() {
        try {
            do {
                lineno++;
                nextLine = source.readLine();
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
                    Product product = new Product(desc, price, upc);
                    productCatalog.add(product);
                }

            } while (nextLine != null);
        } catch (IOException e) {
            System.out.println("**** Invalid Product Catalog Database **** " + e);

        }
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }

    public void addNewProduct(String desc, double price, String upc) {
        Product product = new Product(desc, price, upc);
        productCatalog.add(product);
    }

    public static int getLineno() {
        return lineno;
    }

    public static ArrayList<String> getSavedSourceFile() {
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
