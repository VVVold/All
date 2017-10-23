package ru.alhorithms.chapter4;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    private boolean[] onStack;
    private Stack<Integer> cycle;



    public DirectedCycle(Digraph DG) {
        marked = new boolean[DG.V()];
        edgeTo = new int[DG.V()];
        for (int i = 0; i < DG.V(); i++)
            if (!marked[i]) dfs(DG, i);
    }

    public void dfs(Digraph DG, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (int w : DG.adj(v)) {
            if (this.hasCycle()) return;
            else if (!marked[v]) {
                edgeTo[w] = v;
                dfs(DG, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w ; x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {return cycle != null;}

    public Iterable<Integer> cycle() {return cycle;}
}
