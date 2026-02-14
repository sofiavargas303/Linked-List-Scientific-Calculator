// Entry point of the program.
public class BigNumArithmetic {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java BigNumArithmetic <inputfile>");
            return;
        }

        FileProcessor.processFile(args[0]);
    }
}
