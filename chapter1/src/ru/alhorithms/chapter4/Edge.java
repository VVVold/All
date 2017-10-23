package ru.alhorithms.chapter4;

import java.io.IOException;

public class Edge implements Comparable<Edge>  {
    private int v;
    private int w;
    private double weight;
    public Edge(int w, int v, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {return weight;}

    public int either() {return v;}

    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Недопустимо ребро");
    }

    @Override
    public int compareTo(Edge edge) {
        if (this.weight() > edge.weight()) return 1;
        else if (edge.weight() > this.weight()) return -1;
        else return 0;
    }
}
