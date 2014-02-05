/*
 * Main Class.
 */
package post;

/**
 *
 * @author terrywong
 */
public class POST {

    private Manager manager;

    public POST(String productFile) {
        manager = new Manager(productFile);
    }

    void run() {
        //System.out.print();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("**** Incorrect usage, try: java post.POST <file>");
            System.exit(1);
        }
        if (args[0].equals("-p")) {
            (new POST(args[1])).run();
        }
    }
}
