/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

/**
 * This is an interface for payment methods.
 *
 * @author terrywong
 */
public interface IPayment {

    public void makePayment(double amountPaid);
}
