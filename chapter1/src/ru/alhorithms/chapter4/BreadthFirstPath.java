package ru.alhorithms.chapter4;

import ru.alhorithms.chapter1.Queue;

import java.util.Stack;

public class BreadthFirstPath {

    private boolean[] marked;
    private int edgeTo[];
    private final int v;

    BreadthFirstPath(Graph G, int v) {
        this.v = v;
        marked = new boolean[G.V];
        edgeTo = new int[G.V];
        bfp(G, v);
    }

    public void bfp(Graph G, int v) {
        Queue<Integer> queue = new Queue<>();
        marked[v] = true;
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            for (int s : G.adj(w))
                if (!marked[s]) {
                    edgeTo[s] = w;
                    marked[s] = true;
                    queue.enqueue(s);
                }
        }
    }

    public boolean hasPathTo(int w) {return marked[w];}

    public Iterable<Integer> pathTo(int w) {
        if(!hasPathTo(w)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = w; x != v; x = edgeTo[x])
            path.push(x);
        path.push(v);
        return path;
    }
}
