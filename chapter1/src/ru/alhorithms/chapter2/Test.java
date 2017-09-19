package ru.alhorithms.chapter2;


import java.util.Random;

public class Test {

    private static boolean less(Comparable a, Comparable b) {return a.compareTo(b) < 0;}

    private static void exch(Comparable [] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable [] a) {for(Comparable s: a) System.out.print(s);}

    public static boolean isSorted(Comparable [] a) {
        for (int i = 1; i < a.length; i++) if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static Comparable[] shuffle(Comparable[] a) {
        Random r = new Random();
        for (int i = a.length; i > 0; i--) exch(a, i-1, r.nextInt(i));
        return a;
    }

    private static String time(int n, Comparable[] a) {
        Comparable[] ArrayCopy = new Comparable[a.length];
        System.arraycopy(a, 0, ArrayCopy, 0, a.length);

//        System.out.println(isSorted(ArrayCopy));
        String string = null;
        long start = System.currentTimeMillis();
        switch (n) {
            case 1:
                SelectionSort.sort(ArrayCopy);
                string = "Сортировка выбором";
                break;
            case 2:
                InsertionSort.sort(ArrayCopy);
                string = "Сортировка вставками";
                break;
            case 3:
                ShellSort.sort(ArrayCopy);
                string = "Сортировка Шелла";
                break;
            case 4:
                MergeSortDown.sort(ArrayCopy);
                string = "Нисходящая сортировка слиянием";
                break;
            case 5:
                MergeSortUp.sort(ArrayCopy);
                string = "Восходящая сортировка слиянием";
                break;
            case 6:
                QuickSort.sort(ArrayCopy);
                string = "Быстрая сортировка";
                break;
            case 7:
                Quick3WaySort.sort(ArrayCopy);
                string = "Быстрая сортировка с трехчастным разбиенем";
                break;
            case 8:
                HeapSort.sort(ArrayCopy);
                string = "Пирамидальная сортировка";
                break;
            default:
                System.out.println("Неверный номер алгоритма");
        }
        long sorTime = System.currentTimeMillis() - start;
//        System.out.println(isSorted(ArrayCopy));
        return string + ": " + sorTime;
    }

    public static void main(String[] args) {
        Random r = new Random();

        int N = 10000000;

        for (int j = N; j >= 100000; j /= 10) {

            System.out.println("\n" + "Массив из " + j + " элементов:" + "\n");

            Comparable[] Array = new Comparable[j];

            for (int i = 0; i < j; i++) Array[i] = i;

            for (int i = 3; i <= 8; i++) System.out.println(time(i, Array));
        }
    }


}
