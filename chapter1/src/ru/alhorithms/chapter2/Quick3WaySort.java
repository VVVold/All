package ru.alhorithms.chapter2;

import java.util.Random;

public class Quick3WaySort {

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            if (less(a[i], v)) exch(a, lt++, i++);
            else if (less(v, a[i])) exch(a, gt--, i);
            else i++;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    public static void sortBM(Comparable[] a) {
        shuffle(a);
        sortBM(a, 0, a.length-1);
    }

    private static void sortBM(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int s = lo, e = hi, i = lo + 1, j = hi;
        Comparable v = a[lo];
        while (true) {
            while (lessOr(a[i--], v)) {
                if (less(a[i], v)) i++;
                else exch(a, i++, s++);
                if (i == e) break;
            }
            while (lessOr(v, a[j--])) {
                    if (v.compareTo(a[j]) == 0) exch(a, j, e--);
                if (j == s) break;
            }
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        sequencing(a, lo, hi, s, e, j);
        sortBM(a, lo, s);
        sortBM(a, e, hi);
    }

    private static void sequencing(Comparable[] a, int lo, int hi, int s, int e, int j) {
        for (int i = lo; i <= hi; i++) {
            if (i >= s && i < j) exch(a, i, i-s);
            else if (i > j && i <= e) exch(a, i, i+hi-e);
        }
    }

    private static boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    private static boolean lessOr(Comparable a, Comparable b) {return a.compareTo(b) <= 0;}


    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {for(Comparable s : a) System.out.print(s + " ");}

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) if(less(a[i], a[i-1])) return false;
        return true;
    }

    private static void shuffle(Comparable[] a) {
        Random r = new Random();
        for (int i = a.length; i > 0 ; i--) exch(a, i-1, r.nextInt(i));
    }

    public static void main(String[] args) {
        int N = 6;
        Integer[] Array = new Integer [N];
        for (int i = 0; i < N; i++) {
            Array[i] = N - i;
        }

        show(Array);
        System.out.println();
        System.out.println(isSorted(Array));
        sortBM(Array);
        show(Array);
        System.out.println();
        System.out.println(isSorted(Array));
    }
}
