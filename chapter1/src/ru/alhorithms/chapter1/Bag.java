package ru.alhorithms.chapter1;

import java.util.Iterator;

public class Bag<Item> implements Iterable {

    private int N = 0;
    private Node first = null;

    @Override
    public Iterator iterator() {
        return new BagIterator();
    }

    class BagIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Object next() {
            if(!isEmpty()) return first.item;
            else return null;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    boolean isEmpty() { return first == null; }

    int size() {return N;}

    void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
}
