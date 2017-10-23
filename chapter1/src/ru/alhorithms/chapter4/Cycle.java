package ru.alhorithms.chapter4;


public class Cycle {
    private boolean [] marked;
    private boolean hasCycle;

    public Cycle(Graph G) {
        marked = new boolean[G.V];

        for (int i = 0; i < G.V; i++)
            dfp(G, i, i);
    }

    private void dfp(Graph G, int v, int w) {
        marked[v] = true;
        for (int s : G.adj(v)) {
            if (!marked[s])
                dfp(G, s, v);
            else if (v != w) hasCycle = true;
        }
    }

    public boolean hasCycle() {return hasCycle;}
}
