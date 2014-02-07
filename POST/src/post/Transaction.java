/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.util.Date;

/**
 * This class describes a transaction.
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
