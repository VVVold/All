package ru.alhorithms.chapter3;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BST<Key extends Comparable, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;
        private Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    private boolean lessOr(Comparable a, Comparable b) {return a.compareTo(b) <= 0;}


    public int size() {return size(root);}

    public int size(Node x) {
        if(x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {
        return get(key, root);
            }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        if (less(key, x.key)) return get(key, x.left);
        else if (less(x.key, key)) return get(key, x.right);
        else return x.value;
    }


    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    private Node put(Key key, Value value, Node x) {
        if (x == null) return new Node(key, value, 1);
        if (less(key, x.key)) return put(key, value, x.right);
        else if (less(x.key, key)) return put(key, value, x.left);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key max() {return max(root).key;}

    private Node max(Node x) {
        if (x.right != null) return max(x.right);
        else return x;
    }

    public Key min() {return min(root).key;}

    private Node min(Node x) {
        if (x.left != null) return max(x.left);
        return x;
    }

    public Key floor(Key key) {
        Node x = floor(key, root);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Key key, Node x) {
        if (x == null) return null;
        if (key.compareTo(x.key) == 0) return x;
        if (less(key, x.left.key)) return floor(key, x.left);
        Node t = floor(key, x.right);
        if (t != null) return t;
        else return x;
    }

    public Key ceiling(Key key) {
        Node x = ceiling(key, root);
        if (x == null) return null;
        return x.key;
    }

    private Node ceiling(Key key, Node x) {
        if (x == null) return null;
        if (key.compareTo(x.key) == 0) return x;
        if (less(x.right.key, key)) return ceiling(key, x.right);
        Node t = ceiling(key, x.right);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {return select(k, root).key;}

    private Node select(int k, Node x) {
        if (x == null) return null;
        int t = size(x.left);
        if (k < t) return select(k, x.left);
        else if (k > t) return select(k-t-1, x.right);
        else return x;
    }

    public int rank(Key key) {return rank(key, root);}

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        if (less(key, x.key)) return rank(key, x.left);
        else if (less(x.key, key)) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    public void deleteMin() {root = deleteMin(root);}

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {root = delete(key, root);}

    private Node delete(Key key, Node x) {
        if (x == null) return null;
        if (less(key, x.key)) return delete(key, x.right);
        else if (less(x.key, key)) return delete(key, x.left);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        ru.alhorithms.chapter1.Queue<Key> queue = new ru.alhorithms.chapter1.Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, ru.alhorithms.chapter1.Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        if (less(lo, x.key)) keys(x.left, queue, lo, hi);
        if (lessOr(lo, x.key) && lessOr(x.key, hi)) queue.enqueue(x.key);
        if (less(x.key, hi)) keys(x.right, queue, lo, hi);
    }

    public void print(Node x) {
        if (x == null) return;
        print(x.left);
        System.out.print(x.key + " ");
        print(x.right);
    }

    public boolean contains(Key key) {
        Value x = get(key, root);
        if (x != null) return true;
        return false;
    }
}
