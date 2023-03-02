package techcourse.jcf.mission;

import java.util.Objects;

public class LinkedList implements SimpleList {
    
    private static class Node {
        
        private final String value;
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
        return null;
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
        return false;
    }
    
    @Override
    public int indexOf(String value) {
        return 0;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }
    
    @Override
    public boolean remove(String value) {
        return false;
    }
    
    @Override
    public String remove(int index) {
        return null;
    }
    
    @Override
    public void clear() {
    
    }
}
