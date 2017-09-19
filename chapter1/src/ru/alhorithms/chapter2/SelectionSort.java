package ru.alhorithms.chapter2;


import java.util.Random;

public class SelectionSort {

    public static void sort(Comparable a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, min, i);
        }
    }

    private static boolean less (Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable a[], int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable a[]) {
        for(Comparable s: a) {
            System.out.print(s + " ");
        }
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        int N = 5;
        Integer[] Array = new Integer [N];
        for (int i = 0; i < N; i++) {
            Array[i] = i;
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
