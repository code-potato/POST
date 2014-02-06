/*
 * This class describes a transaction.
 */
package post;

import java.util.Date;

/**
 *
 * @author terrywong
 */
public class Transaction {

    private Customer customer;
    private IPayment payment;
    private String dateTime;

    public Transaction(Customer c, IPayment pt) {
        customer = c;
        payment = pt;
        dateTime = String.format("%tc", new Date());
    }

    public String getDateTime() {
        return dateTime;
    }

    public Customer getCustomer() {
        return customer;
    }
}
