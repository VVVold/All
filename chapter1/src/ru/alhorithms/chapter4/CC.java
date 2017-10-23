package ru.alhorithms.chapter4;


public class CC {
    private boolean[] marked;
    private int count;
    private int[] id;

    public CC(Graph G) {
        marked = new boolean[G.V];
        id = new int[G.V];
        for (int s = 0; s < G.V; s++) {
            dpf(G, s);
            count++;
        }
    }

    private void dpf(Graph G, int s) {
        marked[s] = true;
        id[s] = count;
        for (int w : G.adj(s))
            if (!marked[s]) dpf(G, s);
    }

    public boolean connected(int v, int w) {return id[w] == id[v];}

    public int id(int v) {return id[v];}

    public int count() {return count;}
}
