package ru.alhorithms.chapter2;


public class IndexMinPQ<Key extends Comparable> {
    private Key[] keys;
    private int[] indexes;
    private int N = 0;
    int max;


    public IndexMinPQ(int max) {
        this.max = max;
        keys = (Key[]) new Object[max+1];
        indexes = new int[max+1];
    }

    public boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    public void exch(int i, int j) {
        Key key =  keys[i];
        keys[i] = keys[j];
        keys[j] = key;
        int index = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = index;
    }


    public void change(int index, Key key) {
        for (int i = 0; i <= N; i++)
            if (indexes[i] == index) keys[i] = key;
    }

    public boolean contains(int index) {
        for (int i = 0; i <= N ; i++)
            if (index == indexes[i]) return true;
        return false;
    }

    public int swim(int k) {
        while (k > 1 && less(keys[k], keys[k/2])) {
            exch(k, k / 2);
            k = k/2;
        } return k;
    }

    public void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && !less(j, j+1)) j++;
            if (less(keys[k], keys[j])) break;
            exch(j, k);
            k = j;
        }
    }

    public int delMin(){
        int index = indexes[1];
        exch(1, N--);
        keys[N+1] = null;
        indexes[N+1] = 0;
        sink(1);
        return index;
    }

    public void insert(int index, Key key) {
        if (N <= max) {
            keys[++N] = key;
            indexes[swim(N)] = index;
        }
    }

    public boolean isEmpty() {return N == 0;}
}
