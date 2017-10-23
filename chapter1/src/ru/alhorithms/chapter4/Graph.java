package ru.alhorithms.chapter4;


import ru.alhorithms.chapter1.Bag;

import java.io.*;

public class Graph {

    public int E;
    public int V;
    public Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(MyInputStream mis) {
        this(mis.read());
        int E = mis.read();
        for (int i = 0; i < V; i++) {
            int v = mis.read();
            int w = mis.read();
            addEdge(w, v);
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        System.out.print(w);
        adj[w].add(v);
        System.out.print(v);
        System.out.println("E = " + E);
        E++;
    }

    public Iterable<Integer> adj(int v) {return adj[v];}


    public static void main(String[] args) throws IOException {
        MyInputStream mis = new MyInputStream("C:\\Users\\User\\Desktop\\All\\chapter1\\src\\ru\\alhorithms\\chapter4\\Graph.txt");
        Graph graph = new Graph(mis);
        System.out.println(graph.E);

    }
}
