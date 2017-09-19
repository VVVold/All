package ru.alhorithms.chapter2;


import java.util.Arrays;

public class HeapSort {

    static void sort(Comparable[] a) {
        int N = a.length-1;

        for (int i = N; i > 0 ; i--) {
            sink(a, i, N);
        }

        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(a[j], a[j+1])) j++;
            if(!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }

//    private static Comparable delMax(Comparable[] a) {
//        int N = a.length-1;
//        Comparable max = a[1];
//        exch(a, 1, N--);
//        sink(a, 1);
//        a[N+1] = null;
//        return max;
//    }

    private static void show(Comparable[] a) {for (Comparable s : a) System.out.print(s + " ");}

    private static boolean isSorted(Comparable[] a) {
        for (int i = 2; i < a.length; i++) if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 8;
        Integer[] Array = new Integer [N];
        for (int i = 1; i < N; i++) {
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
