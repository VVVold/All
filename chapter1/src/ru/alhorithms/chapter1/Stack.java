package ru.alhorithms.chapter1;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    int N = 0;
    int Ne;
    Node first = null;


    class Node {
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

    Item delete(int k) {
        Node node = first;
        Item item = null;
        Item[] items = (Item[])new Object[k];
        for (int i = 0; i < k; i++) {
            item = first.item;
            items[i] = first.item;
            first = first.next;
        }
        for (int i = k - 2; i >= 0; i--) {
            Node oldfirst = first;
            first = new Node();
            first.item = items[i];
            first.next = oldfirst;
        }
        N--;
        return item;
    }

//    Item max(Node first) {
//        first = this.first;
//        Item max = this.first.item;
//        if (max < first.item) max = first.item;
//        if (first ==  null) return max;
//        return max(first.next);
//    }

    Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    Node reverseRec(Node first) {
        System.out.println(first.item);
        if(first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = reverseRec(second);
        second.next = rest;
        first.next = null;
        System.out.println(first.item);
        return rest;

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
