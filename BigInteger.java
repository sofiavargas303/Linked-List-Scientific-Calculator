// BigInteger represents a very large integer using a linked list.
// Digits are stored BACKWARDS (least significant digit first).
public class BigInteger {

    private Node head;  // Head points to the 1's place digit

    // Constructor: builds the linked list from a string number
    public BigInteger(String num) {

        // Remove spaces and leading zeros
        num = num.trim();
        int i = 0;
        while (i < num.length() - 1 && num.charAt(i) == '0') i++;
        num = num.substring(i);

        // Insert digits so they are stored backwards
        // Example "123" becomes 3 → 2 → 1
        for (int j = 0; j < num.length(); j++) {
            int digit = Character.getNumericValue(num.charAt(j));
            addDigit(digit);
        }
    }

    // Adds a digit to the FRONT of the list
    private void addDigit(int digit) {
        Node newNode = new Node(digit);
        newNode.next = head;
        head = newNode;
    }

    // ADDITION 
    // Works like elementary school addition.
    public BigInteger add(BigInteger other) {

        Node n1 = this.head;
        Node n2 = other.head;

        BigInteger result = new BigInteger("0");
        result.head = null;

        int carry = 0;

        while (n1 != null || n2 != null || carry != 0) {
            int sum = carry;

            if (n1 != null) {
                sum += n1.digit;
                n1 = n1.next;
            }

            if (n2 != null) {
                sum += n2.digit;
                n2 = n2.next;
            }

            carry = sum / 10;
            result.addDigit(sum % 10);
        }

        return result;
    }

    // MULTIPLICATION
    // Works like paper multiplication.
    public BigInteger multiply(BigInteger other) {

        BigInteger result = new BigInteger("0");

        Node a = this.head;
        int shift = 0;

        while (a != null) {

            BigInteger temp = new BigInteger("0");
            temp.head = null;

            // add zeros for shifting
            for (int i = 0; i < shift; i++) temp.addDigit(0);

            int carry = 0;
            Node b = other.head;

            while (b != null) {
                int product = a.digit * b.digit + carry;
                carry = product / 10;
                temp.addDigit(product % 10);
                b = b.next;
            }

            if (carry != 0) temp.addDigit(carry);

            result = result.add(temp);
            shift++;
            a = a.next;
        }

        return result;
    }

    // EXPONENT
    // Uses exponentiation by squaring (fast method).
    public BigInteger exponent(int exponent) {

        BigInteger result = new BigInteger("1");
        BigInteger base = this;

        while (exponent > 0) {
            if (exponent % 2 == 1)
                result = result.multiply(base);

            base = base.multiply(base);
            exponent /= 2;
        }

        return result;
    }

    // Converts linked list back into a readable string.
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.digit);
            current = current.next;
        }

        return sb.reverse().toString();  // reverse because digits stored backwards
    }
}
