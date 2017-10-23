package ru.alhorithms.chapter4;


public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

   DepthFirstSearch(Graph G, int v){
       marked = new boolean[G.V];
       dfs(G, v);
   }

   private void dfs(Graph G, int v) {
       marked[v] = true;
       for (int w : G.adj(v))
           if (!marked[w]) dfs(G, w);
   }

   public int count() {return count;}

   public boolean isMarked(int v) {return marked[v];}
}
