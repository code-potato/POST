/*
 * The manager will open the store, set up Post(s), put together the product catalog
 */
package post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author terrywong
 */
public class Manager {

    private Store store;
    private String Invoice;
    private TransactionReader transactionRecord;
    private TransactionLog transactionLog;
    private ArrayList<Transaction> transactions;
    private static ArrayList<Product> productCatalog;
    private HashMap<String, Integer> transactionPurchases;

    public Manager(String productFile, String transactionFile) {
        try {
            store = new Store();
            store.init(productFile);
            transactionRecord = new TransactionReader(transactionFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    // Load transactions and print an invoice
    public void manage() {
        transactionRecord.loadTransactions();
        transactionRecord.close();
        generateInvoice();
        System.out.print(Invoice);
    }

    // Generate a invoice for printing
    private void generateInvoice() {
        transactions = transactionRecord.getTransactions();
        productCatalog = store.getProductCatalog();
        Invoice = store.getName() + "\n\n";
        for (Transaction t : transactions) {
            Invoice += String.format("Customer: %-15s %-20s\n", t.getCustomer().getName(), t.getDateTime());
            Invoice += String.format("%-12s %-12s %-12s %-12s\n", "Item:", "QTY:", "Unit Price:", "Subtotal:");
            transactionPurchases = t.getCustomer().getPurchases();
            for (Map.Entry entry : transactionPurchases.entrySet()) {
                for (Product p : productCatalog) {
                    if (entry.getKey().equals(p.getUPC())) {
                        Invoice += String.format("%-12s %-12s %-12s %-12s\n", p.getDescription(), entry.getValue(), p.getPrice(), p.getPrice() * Double.valueOf(entry.getValue().toString()));
                    }
                }
            }
            Invoice += "\n";
        }
    }

    // Logs an invoice for record
    private void logInvoice() {
        transactionLog = new TransactionLog();

    }
}
