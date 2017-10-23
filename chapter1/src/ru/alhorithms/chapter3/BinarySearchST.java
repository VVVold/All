package ru.alhorithms.chapter3;

import java.util.Arrays;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    Key[] keys;
    Value[] values;
    private int N = 0;

    BinarySearchST(int N) {
        keys = (Key[])new Comparable[N];
        values = (Value[])new Comparable[N];
    }

    public int size() {return N;}

    private void resize(int N) {
        Key[] keys1 = (Key[])new Comparable[N];
        Value[] values1 = (Value[])new Comparable[N];
        for (int i = 0; i < keys.length; i++) {
            keys1[i] = keys[i];
            values1[i] = values[i];
        }
        keys = keys1;
        values = values1;
    }

    private int rank(Key key, int lo, int hi) {
        if (lo >= hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (less(key, keys[mid])) return rank(key, lo, mid - 1);
        else if (less(keys[mid], key)) return rank(key, mid + 1, hi);
        else return mid;
    }

    public void put(Key key, Value value) {
        if (N == keys.length) resize(2*N);
        if (N == 0) {keys[0] = key; values[0] = value;}
        else {
            int r = rank(key, 0, N-1);
            if(less(keys[r], key)) r = r + 1;
            for (int i = N-1; i >= r; i--) {
                keys[i+1] = keys[i];
                values[i+1] = values[i];
            }
            keys[r] = key;
            values[r] = value;
        }
        N++;
    }

    public Value get(Key key) {
        if(key.equals(keys[rank(key, 0, N-1)])) return values[rank(key, 0, N-1)];
        else return null;
    }

    public boolean less(Key a, Key b) {return a.compareTo(b) < 0;}

    private void exch(Object i, Object j) {
        Object t = i;
        i = j;
        j = t;
    }

    public void show() {
        for (int i = 0; i < N; i++) {
            System.out.println(keys[i] + " : " + values[i]);
        }
    }

    public static void main(String[] args) {
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>(4);
        st.put(1, 1);
        st.put(2, 2);
        st.put(3, 3);
        st.put(4, 4);
        st.put(1, 1);
        st.put(1, 1);
        st.put(13, 13);
        st.put(12, 12);
        System.out.println(st.get(13));
        System.out.println(st.get(5));
        System.out.println(Arrays.toString(st.keys));
        System.out.println(Arrays.toString(st.values));


    }

}
