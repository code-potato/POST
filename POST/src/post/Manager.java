/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The manager will open the store, set up Post(s), put together the product
 * catalog.
 *
 * @author terrywong
 */
public class Manager {

    private Store store;
    private String Invoice;
    private ProductCatalog productCatalog;
    private TransactionReader transactionRecord;
    private TransactionLog transactionLog;
    private ArrayList<Transaction> transactions;
    private HashMap<String, Integer> transactionPurchases;

    /**
     * The constructor of a Manager class sets up a store and loads the record
     * of all transactions.
     *
     * @param productFile
     * @param transactionFile
     */
    public Manager(String productFile, String transactionFile) {
        try {
            store = new Store();
            store.init(productFile);
            transactionRecord = new TransactionReader(transactionFile);
            transactionLog = new TransactionLog();
        } catch (IOException e) {
            System.err.println("**** " + e);
        }
    }

    /**
     * Load transactions and print an invoice
     */
    public void manage() {
        try {
            transactionRecord.loadTransactions();
            transactionRecord.close();
            generateInvoice();
            System.out.print(Invoice);
        } catch (IOException e) {
            System.err.println("**** " + e);
        }

    }

    /**
     * Generate an invoice for printing
     */
    private void generateInvoice() throws IOException {
        productCatalog = store.getProducts();
        transactions = transactionRecord.getTransactions();
        Invoice = store.getName() + "\n\n";
        for (Transaction t : transactions) {
            Invoice += String.format("%-25s %-20s\n", "Customer Name:", "Date & Time:");
            Invoice += String.format("%-25s %-20s\n", t.getCustomer().getName(), t.getDateTime());
            Invoice += String.format("%-12s %-12s %-12s %-12s\n", "Item:", "QTY:", "Unit Price:", "Subtotal:");
            transactionPurchases = t.getCustomer().getPurchases();
            for (Map.Entry entry : transactionPurchases.entrySet()) {
                Product product = productCatalog.getProduct(entry.getKey().toString());
                if (product != null) {
                    Invoice += String.format("%-12s %-12s %-12s %-12s\n", product.getDescription(), entry.getValue(), product.getPrice(), product.getPrice() * Double.valueOf(entry.getValue().toString()));
                } else {
                    throw new IOException("**** UPC already exists! ****");
                }
            }
            Invoice += "\n";
        }
    }

    /**
     * Logs an invoice for record
     */
    private void logInvoice() {

    }
}
