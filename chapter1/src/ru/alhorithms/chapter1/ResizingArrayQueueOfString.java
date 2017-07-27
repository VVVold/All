package ru.alhorithms.chapter1;

import java.util.Arrays;

public class ResizingArrayQueueOfString<Item> {
    private int N = 0;
    private int S = 2;
    private Item[] items;

    ResizingArrayQueueOfString() {

    }

    boolean isEmpty() {return N == 0;}

    int size () { return N;}

    void enqueue(Item item) {
        if (isEmpty()) { items = (Item[])new Object[S];
            System.out.println("First"); }
        if (N >= S) {
            S = 2*S;
            Item[] items2 = (Item[])new Object[S];
            for (int i = 0; i < N; i++) {
                items2[i] = items[i];
            }
            items = items2;
        }
        items[N] = item;
        N++;
        System.out.println(N);
        System.out.println(item);
        System.out.println(S);
        System.out.println(Arrays.asList(items));
    }

    Item dequeue() {
        if (isEmpty()) {
            System.out.println("Пустая очередь");
            return null;
        }
        Item item = items[0];
        Item[] items2 = (Item[])new Object[S];
        for (int i = 0; i < N - 1; i++) {
            items2[i] = items[i + 1];
        }
        items = items2;
        N--;
        if (N <= S/3) {
            S = S/2;
            Item[] items3 = (Item[])new Object[S];
            for (int i = 0; i < N; i++) {
                items3[i] = items[i];
            }
            items = items3;
        }
        System.out.println(Arrays.asList(items));
        return item;
    }

}
