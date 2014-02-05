/*
 * The manager will open the store, set up Post(s), put together the product catalog
 */
package post;

/**
 *
 * @author terrywong
 */
public class Manager {

    private Store store;

    public Manager(String productFile) {
        store = new Store();
        store.init(productFile);
    }
}
