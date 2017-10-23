package ru.alhorithms.chapter4;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count = 0;


    public KosarajuSCC(Digraph DG) {
        marked = new boolean[DG.V()];
        DepthFirstOrder dfs = new DepthFirstOrder(DG.digraphReverse());
        for (int i : dfs.reversePost())
            if (!marked[i]) {
                dfs(DG, i);
                count++;
            }
    }

    public void dfs(Digraph DG, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : DG.adj(v))
            if (!marked[w])
                dfs(DG, w);
    }

    public boolean stonglyConnected(int v, int w) {return id[v] == id[w];}

    public int id(int v) {return id[v];}

    public int count() {return count;}
}
