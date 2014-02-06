/*
 * This is a abstract class for payment methods.
 */
package post;

/**
 *
 * @author terrywong
 */
public interface IPayment {

    public void makePayment(double amountPaid);
}
