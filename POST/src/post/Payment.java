/*
 * This is a abstract class for payment methods.
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
