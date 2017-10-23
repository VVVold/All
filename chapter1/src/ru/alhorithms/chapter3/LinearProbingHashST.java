package ru.alhorithms.chapter3;


import java.util.Objects;

public class LinearProbingHashST<Key, Value> {
    private Key [] keys;
    private Value [] values;
    private int M, N;

    public LinearProbingHashST(int M) {
        keys = (Key[])new Object[M];
        values = (Value[])new Object[M];
    }

    private int hash(Key key) {return (key.hashCode() & 0x7fffffff) % M;}

    private void resize(int size) {
        Key[] keys1 = (Key[])new Object[size];
        Value[] values1 = (Value[])new Object[size];
        for (int i = 0; i < M; i++) {
            keys1[i] = keys[i];
            values1[i] = values[i];
        }
        keys = keys1;
        values = values1;
        M = size;
    }

    public void put(Key key, Value value) {
        if (N > M / 2) resize(M * 2);
        int i;
        for (i = hash(key); keys[i] != null ; i = (i + 1) % M)
            if (key.equals(keys[i])) values[i] = value;
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (key.equals(keys[i])) return values[i];
        return null;
    }

    public void delete(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (!key.equals(keys[i])) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i+1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i+1) % M;
        while (keys[i] != null) {
            Key key1 = keys[i];
            Value value1 = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(key1, value1);
            i = (i+1) % M;
        }
        N--;
        if (N > 0 && N < M / 8) resize(M / 2);
    }
}
