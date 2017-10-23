package ru.alhorithms.chapter4;

import ru.alhorithms.chapter3.BST;

import javax.swing.*;

public class SymbolGraph {
    private Graph G;
    private String[] keys;
    private BST<String, Integer> st;

    SymbolGraph(MyInputStream mis, String sp) {
        st = new BST<String, Integer>();

        while (mis.hasNextLine()) {
            String[] string = mis.readLine().split(sp);
            for (String aString : string) {
                if (!st.contains(aString))
                    st.put(aString, st.size());
            }
        }

        keys = new String[st.size()];
        for (String name : st.keys())
            keys[st.get(name)] = name;

        G = new Graph(st.size());

        while (mis.hasNextLine()) {
            String [] string = mis.readLine().split(sp);
            int v = st.get(string[0]);
            for (int i = 0; i < st.size(); i++)
                G.addEdge(v, st.get(string[i]));
        }
    }

    public String name(int v) {return keys[v];}

    public int index(String string) {return st.get(string);}

    public Graph G() {return G;}

    public boolean contain(String string) {return st.contains(string);}

    public int size() {return st.size();}
}
