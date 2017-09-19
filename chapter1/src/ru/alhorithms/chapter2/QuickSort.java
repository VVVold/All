package ru.alhorithms.chapter2;


import java.util.Random;

public class QuickSort {

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

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
        for (int i = a.length; i > 0; i--) exch(a, i-1, r.nextInt(i));
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
        sort(Array);
        show(Array);
        System.out.println();
        System.out.println(isSorted(Array));
    }
}
