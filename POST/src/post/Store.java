/*
 * This class implements a store and its operations.
 *
 */
package post;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author terrywong
 */
public class Store {

    private String name, address;
    private static final String DEFAULT_NAME = "SFSU Merchandise Store";
    private static final String DEFAULT_ADDRESS = "1600 Holloway Avenue . San Francisco . CA 94132";
    private ProductCatalog productCatalog;

    public Store() {
        name = DEFAULT_NAME;
        address = DEFAULT_ADDRESS;
    }

    public Store(String nm, String addr) {
        if (nm == null) {
            name = DEFAULT_NAME;
        } else {
            name = nm;
        }
        if (addr == null) {
            address = DEFAULT_ADDRESS;
        } else {
            address = addr;
        }
    }

    public void init(String productFile) {
        try {
            productCatalog = new ProductCatalog(productFile);
            productCatalog.loadProducts();
            productCatalog.close();
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String nm) {
        name = nm;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addr) {
        address = addr;
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog.getProductCatalog();
    }
}
