package ru.alhorithms.chapter2;


import java.util.Arrays;
import java.util.Random;

public class MinPQ<Key extends Comparable> {
    private Key[] pq;
    private int N = 0;

    public MinPQ(int MaxM) {pq = (Key[]) new Comparable[MaxM + 1];}

    public boolean isEmpty() {return N == 0;}

    public int size() {return N;}

    public void insert(Key v) {
        if (N < pq.length-1) {
            pq[++N] = v;
            swim(N);
        }
        else {
            if (less(v, pq[1])) {
                delMax();
                pq[++N] = v;
                swim(N);
            }
        }
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

//    public Key max() {return pq[1];}

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private boolean less(Key a, Key b) {return a.compareTo(b) < 0;}

    private void swim(int k) {
        while (k > 1 && less(pq[k/2], pq[k])) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(pq[j], pq[j+1])) j++;
            if (!less(pq[k], pq[j])) break;
            exch(k, j);
            k = j;
        }
    }

    public void show() {for (Key s : pq) System.out.print(s + " ");}

    public static void main(String[] args) {
        int n = 15;
        Random random = new Random();
        MinPQ<Integer> integerMaxPQ = new MinPQ<>(n);
        int[] arr = new int[3*n];
        for (int i = 0; i < 3*n; i++)
            integerMaxPQ.insert(arr[i] =  i);
        System.out.println(Arrays.toString(arr));
        integerMaxPQ.show();
        System.out.println();
        integerMaxPQ.delMax();
        integerMaxPQ.show();
        System.out.println();
        integerMaxPQ.delMax();
        integerMaxPQ.show();
        System.out.println();
        integerMaxPQ.delMax();
        integerMaxPQ.show();

    }
}
