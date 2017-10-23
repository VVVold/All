package ru.alhorithms.chapter4;

import ru.alhorithms.chapter1.Queue;

import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    DepthFirstOrder(Digraph DG) {
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();
        marked = new boolean[DG.V()];
        for (int i = 0; i < DG.V(); i++)
            if (!marked[i]) dfs(DG, i);
    }

    private void dfs(Digraph DG, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : DG.adj(v))
            if (!marked[w]) dfs(DG, w);
        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {return pre;}
    public Iterable<Integer> post() {return post;}
    public Iterable<Integer> reversePost() {return reversePost;}
}
