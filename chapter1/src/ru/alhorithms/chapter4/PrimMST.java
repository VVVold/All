package ru.alhorithms.chapter4;

import ru.alhorithms.chapter2.IndexMinPQ;

public class PrimMST {
    public boolean[] marked;
    public Edge[] edgeTo;
    public double[] distTo;
    public IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        for (int i = 0; i < G.V(); i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    public void visit(EdgeWeightedGraph G, int w) {
        marked[w] = true;
        for (Edge e : G.adj(w)) {
            int v = e.other(w);
            if (marked[v]) continue;
            if (e.weight() < distTo[v]) {
                edgeTo[v] = e;
                distTo[v] = e.weight();
                if (pq.contains(v)) pq.change(v, distTo[v]);
                else pq.insert(v, distTo[v]);
            }
        }
    }
}
