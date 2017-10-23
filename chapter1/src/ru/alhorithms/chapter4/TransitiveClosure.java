package ru.alhorithms.chapter4;


public class TransitiveClosure {
    private DirectedDFS[] all;

    TransitiveClosure(Digraph DG) {
        all = new DirectedDFS[DG.V()];
        for (int i = 0; i < DG.V(); i++)
            all[i] = new DirectedDFS(DG, i);
    }

    boolean reachable(int v, int w) {return all[v].marked(w);}

}
