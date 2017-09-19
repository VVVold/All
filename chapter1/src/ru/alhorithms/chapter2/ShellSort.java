package ru.alhorithms.chapter2;


public class ShellSort {
    public static void sort(Comparable[] a) {
        int h = 1;
        while (h < a.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exch(a, j, j - h);
            } h /= 3;
        }
    }
    private static boolean less(Comparable a, Comparable b) { return a.compareTo(b) < 0; }

    private static void exch(Comparable[] a, int i1, int j1) {
        Comparable t = a[i1];
        a[i1] = a[j1];
        a[j1] = t;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if(less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void show(Comparable[] a) {
        for (Comparable s: a) System.out.print(s + " ");
    }

    public static void main(String[] args) {
        Integer[] Array = new Integer [] {4,8,3,9,8,5,6,7,0,5,4,3,4,8,3,9,8,5,6,7,0,5,4,3,4,8,3,9,8,5,6,7,0,5,4,3};
        System.out.println(isSorted(Array));
        sort(Array);
        show(Array);
        System.out.println();
        System.out.println(isSorted(Array));
    }
}
