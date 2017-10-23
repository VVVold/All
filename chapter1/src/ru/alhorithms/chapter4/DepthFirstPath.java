package ru.alhorithms.chapter4;

import java.io.InputStream;
import java.util.Stack;

public class DepthFirstPath {

    private boolean marked[];
    private int edgeTo[];
    private final int v;


    public DepthFirstPath(Graph G, int v) {
        this.v = v;
        marked = new boolean[G.V];
        edgeTo = new int[G.V];
        dfp(G, v);
    }

    public void dfp(Graph G, int w) {
        marked[w] = true;
        for (int s : G.adj(w))
            if (!marked[w]) {
                edgeTo[s] = w;
                dfp(G, s);
            }
    }

    public boolean hasPathTo(int w) {return marked[v];}

    public Iterable<Integer> pathTo(int w) {
        if (!hasPathTo(w)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = w; x != v; x = edgeTo[x])
            path.push(x);
        path.push(v);
        return path;
    }
}
