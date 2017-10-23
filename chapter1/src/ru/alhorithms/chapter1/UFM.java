package ru.alhorithms.chapter1;


public class UFM {
    private int[] id;
    private int[] sz;
    int count;

    public UFM(int size) {
        id = new int[size];
        sz = new int[size];
        count = size;
        for (int i = 0; i < size; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    private int find(int p) {
        while (id[p] != p) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (sz[rootP] > sz[rootQ]) {
            id[rootQ] = rootP;
            sz[p] += sz[q];
        } else {
            id[rootP] = rootQ;
            sz[q] += sz[p];
        }
        count--;
    }

    public boolean isConnected(int p, int q) {return find(p) == find(q);}



}
