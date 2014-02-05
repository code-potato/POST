/*
 * This class implements a store and its operations.
 *
 */
package post;

/**
 *
 * @author terrywong
 */
public class Store {

    private String name, address;
    private static final String NAME = "SFSU Merchandise Store";
    private static final String DEFAULT_ADDRESS = "1600 Holloway Avenue . San Francisco . CA 94132";

    public Store() {
        name = NAME;
        address = DEFAULT_ADDRESS;
    }

    public Store(String nm, String addr) {
        if (nm == null) {
            name = NAME;
        } else {
            name = nm;
        }
        if (addr == null) {
            address = DEFAULT_ADDRESS;
        } else {
            address = addr;
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

}
