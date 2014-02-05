/*
 * Execute a trasaction from file
 */
package post;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author terrywong
 */
public class TransactionReader {

    private BufferedReader source;
    protected static int lineno = -1;
    private String nextLine, customerName, TransactionItem, Payment;
    private static ArrayList<String> savedTransactionFile;
    private static ArrayList<Transaction> transactions;

    /**
     * Construct a new ProductReader for a product catalog.
     *
     * @param transactionFile
     * @exception IOException is thrown if there is an I/O problem
     */
    public TransactionReader(String transactionFile) throws IOException {
        System.out.println("Transaction File: " + transactionFile);
        System.out.println();
        source = new BufferedReader(new FileReader(transactionFile));
        savedTransactionFile = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    void close() {
        try {
            source.close();
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    /**
     * Load all the products from file.
     *
     * @return
     */
    public void loadTransactions() {
        try {
            do {
                lineno++;
                nextLine = source.readLine();
                if (nextLine != null) {
                    savedTransactionFile.add(nextLine);
                } else {
                    break;
                }
                if (nextLine != "") {
                    StringTokenizer st = new StringTokenizer(nextLine);
                }

            } while (nextLine != null);
        } catch (IOException e) {
            System.out.println("**** Invalid Product Catalog Database **** " + e);

        }
    }

    public static int getLineno() {
        return lineno;
    }

    public static ArrayList<String> getSavedSourceFile() {
        return savedTransactionFile;
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
