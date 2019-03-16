package training.other;

class Node {
    private String value;
    private Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}

public class ReverseLinkedList {
    // build a singly linked list from an array of String values
    private static Node buildList(String... values) {
        Node head = null;
        Node current = null;
        for (String value : values) {
            Node node = new Node(value, null);
            if (head == null) {
                head = node;
                current = node;
            }
            current.setNext(node);

            current = node;
        }

        return head;
    }

    private static Node reverse(Node head) {
        Node current = head;
        Node next = current.getNext();
        head.setNext(null);

        while (next != null) {
            Node tmp = next.getNext();
            next.setNext(current);
            current = next;
            next = tmp;
        }

        return current;
    }

    public static void main(String[] args) {
        Node list = buildList("1", "2", "3", "4", "5");

        System.out.println("list = " + list);
        System.out.println("list = " + reverse(list));
    }
}
