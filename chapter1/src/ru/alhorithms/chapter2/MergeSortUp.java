package ru.alhorithms.chapter2;


public class MergeSortUp {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int lo = 0; lo < a.length-sz; lo += 2*sz)
                merge(a, lo, lo+sz-1, Math.min(lo+2*sz-1, a.length-1));
        }
    }

    private static boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    public static void show(Comparable[] a) {for(Comparable s : a) System.out.print(s + " ");}

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) if (less(a[i], a[i-1])) return false;
        return true;
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
