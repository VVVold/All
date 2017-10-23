package ru.alhorithms.chapter1;


import java.util.Iterator;

public class Queue<Item> implements Iterable {

    private int N = 0;
    private Node first = null;
    private Node last = null;

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            if (hasNext() == true) return first.item;
            else return null;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return N == 0; }

    int size() { return N; }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
