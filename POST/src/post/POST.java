/*
 * Main class for POSTs.
 */
package post;

/**
 *
 * @author terrywong
 */
public class POST {

    private Manager manager;

    public POST(String productFile, String transactionFile) {
        manager = new Manager(productFile, transactionFile);
    }

    void run() {
        manager.manage();
    }

    /**
     * Take -p <product file> -t <transaction file> as arguments
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //System.out.println(args.length);
        if (args.length == 0 || args.length != 4) {
            System.out.println("**** Incorrect usage, try: java post.POST -p <product file> -t <transaction file>");
            System.exit(1);
        }
        if (args[0].equals("-p") && args[2].equals("-t")) {
            (new POST(args[1], args[3])).run();
        } else if (args[0].equals("-t") && args[2].equals("-p")) {
            (new POST(args[3], args[1])).run();
        }
    }
}
