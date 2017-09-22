// Brittni Watkins
// Unit 4: Linked Lists
// Homework 1 - Deleting Elements from a Linked List
// Linked List Class

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Adding an element to the end of the list
    public void add(Circle c) {
        Node n = new Node(c);

        if (isEmpty()) {
            head = n;
        } else {
            Node curr = head; // start at the beginning of the list

            while (curr.getNext() != null) {
                curr = curr.getNext(); // traverse to the end of the list
            }

            curr.setNext(n); // add element to the end
        }

        size++; // increment the length
    }

    public void add(Circle c, int index) {

        if (index >= 0 && index <= size) {

            if (index == 0) {
                Node temp = head;
                head = new Node(c);
                head.setNext(temp);
                size++;
            } else if (index == size) {
                add(c);
            } else {
                int i = 0;
                Node curr = head;
                Node toAdd = new Node(c);

                while (i < index - 1) {
                    curr = curr.getNext();
                    i++;
                }

                toAdd.setNext(curr.getNext());
                curr.setNext(toAdd);
                size++;
            }

        }

    }

    // linked list will be zero-indexed
    public Circle get(int index) {
        Circle c = null;

        if (index >= 0 && index < size) {
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
        return (head == null) && (size == 0);
    }

    public int size() {
        return size;
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
