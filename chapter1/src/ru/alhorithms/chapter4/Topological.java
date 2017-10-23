package ru.alhorithms.chapter4;


public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph DG) {
        DirectedCycle dc = new DirectedCycle(DG);
        if (!dc.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(DG);
            order = dfo.reversePost();
        }
    }

    public Iterable<Integer> order() {return order;}

    public boolean isDAG() {return order == null;}
}
