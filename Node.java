// Node represents a single digit in our linked list.
// Each node stores ONE digit (0–9).
class Node {
    int digit;      // The digit stored at this position
    Node next;      // Pointer to the next digit

    public Node(int digit) {
        this.digit = digit;
        this.next = null;
    }
}
