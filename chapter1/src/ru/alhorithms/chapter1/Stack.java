package ru.alhorithms.chapter1;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private int N = 0;
    private Node first = null;


    private class Node {
        Item item;
        Node next;
    }

    boolean isEmpty() {return first == null;}

    int size() {return N;}

    void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {return first != null;}

        @Override
        public Item next() {
            if (hasNext() == true) return first.item;
            else return null;
        }
    }
}
