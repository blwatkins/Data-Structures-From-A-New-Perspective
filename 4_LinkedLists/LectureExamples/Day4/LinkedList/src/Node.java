// Brittni Watkins
// Unit 4: Linked Lists
// Day 4 - Implementing a Linked List
// Node Class

public class Node {
    private Circle data;
    private Node next;

    public Node(Circle data) {
        this.data = data;
        next = null;
    }

    public Node getNext() {
        return next;
    }

    public Circle getData() {
        return data;
    }

    public void setNext(Node n) {
        next = n;
    }

    public String toString() {
        String out = "";
        out += data + "\n";
        return out;
    }

}
