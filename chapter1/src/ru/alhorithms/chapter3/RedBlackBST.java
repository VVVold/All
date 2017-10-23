package ru.alhorithms.chapter3;


import ru.alhorithms.chapter1.Queue;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static boolean RED = true;
    private static boolean BLACK = false;
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private int N;
        private boolean color;
        private Node left, right;
        private Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    private boolean lessOr(Comparable a, Comparable b) {return  a.compareTo(b) <= 0;}

    public int size() {return size(root);}

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public Value get(Key key) {return get(key,root);}

    private Value get(Key key, Node x) {
        if (x == null) return null;
        if (less(key, x.key)) return get(key, x.right);
        else if (less(x.key, key)) return get(key, x.left);
        else return x.value;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private boolean isRED(Node x) {
        if (x == null) return false;
        return x.color;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = BLACK;
    }

    private Node put(Key key, Value value, Node h) {
        if (h == null) return new Node(key, value, 1, RED);
        if (less(key, h.key)) return put(key, value, h.left);
        else if (less(h.key, key)) return put(key, value, h.right);
        else h.value = value;

        if (isRED(h.right) && !isRED(h.left)) rotateLeft(h);
        if (isRED(h.left) && isRED(h.left.left)) rotateRight(h);
        if (isRED(h.left) && isRED(h.right)) flipColors(h);
        h.N = size(h.left) +  size(h.right) + 1;
        return h;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null) return null;
        if (x.left != null) return min(x.left);
        return x;
    }

    public Key max() {return max(root).key;}

    private Node max(Node x) {
        if (x == null) return null;
        if (x.right != null) return max(x.right);
        return x;
    }

    public Key floor(Key key) {
        if (floor(key, root) == null) return null;
        return floor(key, root).key;
    }

    private Node floor(Key key, Node x) {
        if (x == null) return null;
        if (key.compareTo(x.key) == 0) return x;
        else if (less(key, x.key)) return floor(key, x.left);
        Node t = floor(key, x.right);
        if (t != null) return t;
        else return x;
    }

    public Key select(int k) {return select(k, root).key;}

    private Node select(int k, Node x) {
        if (x == null) return null;
        int t  = size(x.left);
        if (t < k) return select(k-t-1, x.right);
        else if (t > k) return select(k, x.left);
        else return x;
    }

    public int rank(Key key) {return rank(key, root);}

    private int rank(Key key, Node x) {
        if (x == null) return 0;
        if (less(x.key, key)) return rank(key, x.left);
        else if (less(key, x.key)) return size(x.left) + rank(key, x.right) + 1;
        else return size(x.left);
    }

    public Iterable<Key> keys() {return keys(min(), max());}

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        if (less(lo, x.key)) keys(x.left, queue, lo, hi);
        if (lessOr(lo, x.key) && lessOr(x.key, hi)) queue.enqueue(x.key);
        if (less(x.key, hi)) keys(x.right, queue, lo, hi);
    }

    private void print(Node x) {
        if (x == null) return;
        print(x.left);
        System.out.print(x.key + " ");
        print(x.right);
    }

}
