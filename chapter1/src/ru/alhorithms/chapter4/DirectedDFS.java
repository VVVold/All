package ru.alhorithms.chapter4;

public class DirectedDFS {
    private boolean[] marked;


    DirectedDFS(Digraph DG, int s) {
        marked = new boolean[DG.V()];
        dfs(DG, s);
    }

    DirectedDFS(Digraph DG, Iterable<Integer> list) {
        marked = new boolean[DG.V()];
        for (int s : list)
            if (!marked[s])
                dfs(DG, s);
    }

    public void dfs(Digraph DG, int s) {
        marked[s] = true;
        for (int w : DG.adj(s))
            if (!marked[w])
                dfs(DG, w);
    }

    public boolean marked(int v) {return marked[v];}
}