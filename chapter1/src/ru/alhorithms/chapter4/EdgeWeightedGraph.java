package ru.alhorithms.chapter4;

import ru.alhorithms.chapter1.Bag;

public class EdgeWeightedGraph {
    private int E;
    private int V;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Edge>();
    }

    public EdgeWeightedGraph(MyInputStream mis) {
        this(mis.read());
        while (mis.hasNextLine()) {
            int v = mis.read();
            int w = mis.read();
            double weight = mis.read();
            Edge edge = new Edge(v, w, weight);
            addEdge(edge);
        }
    }

    public int V() {return V;}

    public int E() {return E;}

    public void addEdge(Edge edge) {
        adj[edge.either()].add(edge);
        adj[edge.other(edge.either())].add(edge);
        E++;
    }

    public Iterable<Edge> edges() {
        Bag<Edge> bag = new Bag<>();
        for (int i = 0; i < V; i++)
            for (Edge e : adj(i))
                if (e.other(i) > i) bag.add(e);
        return bag;
    }

    public Iterable<Edge> adj(int i) {return adj[i];}
}
