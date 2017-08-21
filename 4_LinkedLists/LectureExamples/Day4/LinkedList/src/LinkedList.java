// Brittni Watkins
// Unit 4: Linked Lists
// Day 4 - Implementing a Linked List
// Linked List Class

public class LinkedList {
    private Node head;
    private int length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    // Adding an element to the end of the list
    public void add(Circle c) {
        Node n = new Node(c);

        if (isEmpty()) {
            head = n;
        } else {
            Node curr = head; // start at the begining of the list

            while (curr.getNext() != null) {
                curr = curr.getNext(); // traverse to the end of the list
            }

            curr.setNext(n); // add element to the end
        }

        length++; // increment the length
    }

    // linked list will be zero-indexed
    public Circle get(int index) {
        Circle c = null;

        if (index >= 0 && index < length) {
            int count = 0;
            Node curr = head;

            while (curr != null) {

                if (count == index) {
                    c = curr.getData();
                    break;
                } else {
                    curr = curr.getNext();
                    count++;
                }

            }

        }

        return c;
    }

    public boolean isEmpty() {
        return (head == null) && (length == 0);
    }

    public int size() {
        return length;
    }


    // printing the list recursively
    public void print() {
        String out = "";
        out += "Length: " + size() + "\n";
        out += print(head);
        System.out.println(out);
    }

    private String print(Node n) {
        String out = "";

        if (n != null) {
            out += n;
            out += print(n.getNext());
        }

        return out;
    }

    // printing the list without recursion
    public String toString() {
        String out = "";

        if (isEmpty()) {
            out += "List is empty";
        } else {
            out += "Length: " + size() + "\n";
            Node curr = head;
            int count = 0;

            while (curr != null) {
                out += count + ": " + curr;
                curr = curr.getNext();
                count++;
            }

        }
        out += "\n";
        return out;
    }

}
