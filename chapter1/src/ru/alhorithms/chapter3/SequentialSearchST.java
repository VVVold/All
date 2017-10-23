package ru.alhorithms.chapter3;

import java.util.Arrays;
import java.util.Stack;

public class SequentialSearchST<Key, Value>  {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {x.value = value; return;}
        first = new Node(key, value, first);
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) return x.value;
        return null;
    }

    public Node delete() {
        Node x = first;
        first = x.next;
        return x;
    }

    public void delete(Key key) {
        Stack<Node> list = new Stack<>();
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)){delete(); break;}

            list.push(delete());
        }

        while (!list.isEmpty()) {
            Node n = list.pop();
            put(n.key, n.value);
        }
    }

    public void show() {
        for (Node x = first; x != null; x = x.next) {
            System.out.println(x.key + " : " + x.value);
        }
    }

    public static void main(String[] args) {
        SequentialSearchST st = new SequentialSearchST();
        st.put(1, "a");
        st.put(2, "b");
        st.put(3, "c");
        st.put(4, "d");
        st.delete(2);
        st.show();


    }

}
