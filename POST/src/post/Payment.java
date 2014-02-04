/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

/**
 *
 * @author terrywong
 */
public abstract class Payment {

    private double amountDue;

    public Payment(double amount) {
        amountDue = amount;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public abstract void makePayment(double amountPaid);
}
