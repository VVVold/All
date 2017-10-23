package ru.alhorithms.chapter3;

import ru.alhorithms.chapter1.Queue;

public class SeparateChainingHashST<Key, Value> {
    private int M, N;
    SequentialSearchST<Key, Value>[] st;


    public SeparateChainingHashST(int M) {
        this.M = M;
        st = new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {return (key.hashCode()& 0x7fffffff) % M;}

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public void delete(Key key) {
        st[hash(key)].delete(key);
    }

//    public Iterable<Key> keys() {
//        Queue<Key> queue = new Queue<Key>();
//        for (int i = 0; i < M; i++) {
//            while (st[i] != null) {}
//        }
//        return queue;
//    }

}
