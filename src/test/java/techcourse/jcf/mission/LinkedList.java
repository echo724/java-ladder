package techcourse.jcf.mission;

import java.util.Objects;

public class LinkedList implements SimpleList {

    private static class Node {

        private String value;
        private Node next;

        public Node(Node next, String value) {
            this.next = next;
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public String getValue() {
            return this.value;
        }

        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }

    private final Node head = new Node(null, "root");
    private int size = 0;
    private Node tail = this.head;

    @Override
    public boolean add(String value) {
        Node node = new Node(null, value);
        this.tail.setNext(node);
        this.tail = node;
        this.size += 1;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (this.size == index) {
            this.add(value);
            return;
        }
        Node node = this.head.getNext();
        int i = 0;
        while (!Objects.isNull(node)) {
            if (i == index) {
                Node next = node.getNext();
                node.setNext(new Node(next, value));
                return;
            }
            node = node.getNext();
            i += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String set(int index, String value) {
        if (this.size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node node = this.head.getNext();
        int i = 0;
        while (!Objects.isNull(node)) {
            if (i == index) {
                return node.setValue(value);
            }
            node = node.getNext();
            i += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String get(int index) {
        Node node = this.head.getNext();
        int i = 0;
        while (!Objects.isNull(node)) {
            if (i == index) {
                return node.getValue();
            }
            node = node.getNext();
            i += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean contains(String value) {
        Node node = this.head.getNext();
        while (!Objects.isNull(node)) {
            if (node.getValue().equals(value)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node node = this.head.getNext();
        int i = 0;
        while (!Objects.isNull(node)) {
            if (node.getValue().equals(value)) {
                return i;
            }
            node = node.getNext();
            i += 1;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean remove(String value) {
        Node node = this.head;
        while (!Objects.isNull(node.getNext())) {
            Node next = node.getNext();
            if (next.getValue().equals(value)) {
                node.setNext(next.getNext());
                this.size -= 1;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public String remove(int index) {
        if (this.size <= index) {
            throw new IndexOutOfBoundsException();
        }
        Node node = this.head;
        int i = 0;
        while (!Objects.isNull(node.getNext())) {
            Node next = node.getNext();
            if (i == index) {
                node.setNext(next.getNext());
                this.size -= 1;
                return next.getValue();
            }
            node = node.getNext();
            i += 1;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public void clear() {
        this.head.setNext(null);
        this.tail = this.head;
        this.size = 0;
    }
}
