package ru.alhorithms.chapter4;

import ru.alhorithms.chapter1.Bag;

import java.util.Objects;

public class Digraph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj =  (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    public Digraph(MyInputStream mis) {
        this(mis.read());
        for (int i = 0; i < V; i++) {
            int v = mis.read();
            int w = mis.read();
            addEdge(v, w);
        }
    }

    public int V() {return V;}

    public int E() {return E;}

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int w) {return adj[w];}

    public Digraph digraphReverse() {
        Digraph reverse = new Digraph(V);
        for (int i = 0; i < V; i++)
            for (Integer w : adj(i))
                reverse.addEdge(w, i);
        return reverse;
    }
}
