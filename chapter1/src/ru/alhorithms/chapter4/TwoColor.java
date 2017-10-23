package ru.alhorithms.chapter4;


public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph G) {
        marked = new boolean[G.V];
        color = new boolean[G.V];
        for (int i = 0; i < G.V; i++) {
            dfp(G, i);
        }
    }

    private void dfp(Graph G, int v) {
        marked[v] = true;
        for (int s : G.adj(v))
            if (!marked[s]) {
                color[s] = !color[v];
                dfp(G, s);
            }
            else if (color[s] == color[v])  isTwoColorable = false;
    }

    public boolean isBepartite() {return isTwoColorable;}

}
