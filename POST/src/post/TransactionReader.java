/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class is for loading transactions from a file.
 *
 * @author terrywong
 */
public class TransactionReader {

    private BufferedReader source;
    protected static int lineno = -1, transactionLine = 0, quantity = 0, creditCardNum;
    private String nextLine, customerName, upc, paymentType;
    private double amountPaid = 0;
    private Customer customer;
    private Transaction transaction;
    private IPayment payment;
    private static ArrayList<String> savedTransactionFile;
    private static ArrayList<Transaction> transactions;

    /**
     * Construct a new TransactionReader for a list of transactions.
     *
     * @param transactionFile
     * @exception IOException is thrown if there is an I/O problem
     */
    public TransactionReader(String transactionFile) throws IOException {
        System.out.println("Transaction File: " + transactionFile);
        System.out.println("");
        source = new BufferedReader(new FileReader(transactionFile));
        if (savedTransactionFile == null) {
            savedTransactionFile = new ArrayList<>();
        }
        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    void close() {
        try {
            source.close();
        } catch (IOException e) {
            System.err.println("**** " + e);
        }
    }

    /**
     * Load all the transactions from a file.
     */
    public void loadTransactions() {
        try {
            do {
                lineno++;
                nextLine = source.readLine();
                if (nextLine != null) {
                    savedTransactionFile.add(nextLine);
                } else {
                    transaction = new Transaction(customer, payment);
                    transactions.add(transaction);
                    break;
                }
                if (nextLine.equals("")) {
                    transaction = new Transaction(customer, payment);
                    transactions.add(transaction);
                    transactionLine = -1;
                } else if (transactionLine == 0) {
                    customerName = nextLine.trim();
                    customer = new Customer(customerName);
                } else if (transactionLine >= 1 && !nextLine.contains("CASH") && !nextLine.contains("CHECK") && !nextLine.contains("CREDIT")) {
                    StringTokenizer st = new StringTokenizer(nextLine);
                    if (st.hasMoreTokens()) {
                        upc = st.nextToken();
                    } else {
                        throw new IOException();
                    }
                    if (st.hasMoreTokens()) {
                        quantity = Integer.valueOf(st.nextToken());
                    } else {
                        quantity = 1;
                    }
                    customer.setPurchases(upc, quantity);
                } else if (nextLine.contains("CASH") || nextLine.contains("CHECK") || nextLine.contains("CREDIT")) {
                    StringTokenizer st = new StringTokenizer(nextLine);
                    if (st.hasMoreTokens()) {
                        paymentType = st.nextToken();
                    } else {
                        throw new IOException();
                    }
                    if (st.hasMoreTokens()) {
                        if (paymentType.equalsIgnoreCase("CASH")) {
                            amountPaid = Double.valueOf(st.nextToken().replace("$", ""));
                            payment = new CashPayment();
                        } else if (paymentType.equalsIgnoreCase("CHECK")) {
                            payment = new CheckPayment();
                        } else if (paymentType.equalsIgnoreCase("CREDIT")) {
                            creditCardNum = Integer.valueOf(st.nextToken());
                            payment = new CreditPayment();
                        }
                    } else {
                        throw new IOException();
                    }
                }
                transactionLine++;
            } while (nextLine != null);
        } catch (IOException e) {
            System.err.println("**** Invalid Transaction File **** " + e);

        }
    }

    public static int getLineno() {
        return lineno;
    }

    public static ArrayList<String> getSavedTransactionFile() {
        return savedTransactionFile;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        String transactionFileOutput = "";
        for (String line : savedTransactionFile) {
            transactionFileOutput += line + "\n";
        }
        return transactionFileOutput;
    }
}
