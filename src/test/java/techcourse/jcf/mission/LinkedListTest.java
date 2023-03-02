package techcourse.jcf.mission;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTest {
    
    private static LinkedList linkedList;
    
    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
    }
    
    @Test
    void add() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.size()).isEqualTo(3);
        assertThat(linkedList.get(0)).isEqualTo("a");
        assertThat(linkedList.get(2)).isEqualTo("c");
    }
    
    @Test
    void testAdd() {
        linkedList.add(0, "a");
        linkedList.add(1, "b");
        assertThat(linkedList.size()).isEqualTo(2);
    }
    
    @Test
    void set() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.set(1, "d")).isEqualTo("b");
        assertThat(linkedList.get(1)).isEqualTo("d");
    }
    
    @Test
    void get() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.get(1)).isEqualTo("b");
    }
    
    @Test
    void contains() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.contains("b")).isTrue();
        assertThat(linkedList.contains("d")).isFalse();
    }
    
    @Test
    void indexOf() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.indexOf("b")).isEqualTo(1);
        assertThat(linkedList.indexOf("d")).isEqualTo(-1);
    }
    
    @Test
    void size() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.size()).isEqualTo(3);
    }
    
    @Test
    void isEmpty() {
        assertThat(linkedList.isEmpty()).isTrue();
        linkedList.add("a");
        assertThat(linkedList.isEmpty()).isFalse();
    }
    
    @Test
    void remove() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.remove("b")).isTrue();
        assertThat(linkedList.size()).isEqualTo(2);
        assertThat(linkedList.remove("d")).isFalse();
        assertThat(linkedList.size()).isEqualTo(2);
    }
    
    @Test
    void testRemove() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        assertThat(linkedList.remove(1)).isEqualTo("b");
        assertThat(linkedList.size()).isEqualTo(2);
    }
    
    @Test
    void clear() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.clear();
        assertThat(linkedList.size()).isEqualTo(0);
    }
}
