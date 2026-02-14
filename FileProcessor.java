import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Handles reading the input file and processing expressions.
public class FileProcessor {

    public static void processFile(String filePath) {

        File infile = new File(filePath);

        try (Scanner scan = new Scanner(infile)) {

            while (scan.hasNextLine()) {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;

                processLine(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }

    // Processes ONE arithmetic expression.
    private static void processLine(String line) {

        int opIndex = -1;
        char operator = ' ';

        // Find operator (+, *, ^)
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '+' || c == '*' || c == '^') {
                operator = c;
                opIndex = i;
                break;
            }
        }

        if (opIndex == -1) {
            System.out.println("Invalid expression: " + line);
            return;
        }

        String left = line.substring(0, opIndex).trim();
        String right = line.substring(opIndex + 1).trim();

        BigInteger num1 = new BigInteger(left);
        BigInteger result = null;

        switch (operator) {
            case '+': result = num1.add(new BigInteger(right)); break;
            case '*': result = num1.multiply(new BigInteger(right)); break;
            case '^': result = num1.exponent(Integer.parseInt(right)); break;
        }

        System.out.println(left + " " + operator + " " + right + " = " + result);
    }
}
