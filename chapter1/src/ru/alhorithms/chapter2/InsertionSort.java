package ru.alhorithms.chapter2;


public class InsertionSort {

    public static void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exch(a, j, j-1);
        }
    }

    private static boolean less(Comparable a, Comparable b) { return a.compareTo(b) < 0; }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void show(Comparable[] a) {
        for(Comparable s: a) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        Integer[] Array = new Integer [] {4,8,3,9,8,5};
        System.out.println(isSorted(Array));
        sort(Array);
        show(Array);
        System.out.println();
        System.out.println(isSorted(Array));
    }
}
