package ru.alhorithms.chapter1;


import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int N = 10;
        int[] A;
        A = new int [N + 1];

        // заполнение массива
        for (int i = 0; i <= N; i = i + 1) {
            A[i] = N - i;
        }

        System.out.println("\nНачальный массив:\n");
        System.out.println(Arrays.toString(A));


        // перемешивание массива
        Random r = new Random();
        int yd,xs;
        for (int i = 0; i <= N; i = i + 1) {
            yd = A[i];
            xs = r.nextInt(N + 1);
            A[i] = A[xs];
            A[xs] = yd;
        }

        System.out.println("\nРандомный массив:\n");
        System.out.println(Arrays.toString(A));
        long start, end;
        int low = 0;
        int high = N;

        start = System.nanoTime();   // получить начальное время
        qSort(A, low, high);
        end = System.nanoTime();    // получить конечное время


        System.out.println("\nПосле сортировки:\n");
        System.out.println(Arrays.toString(A));
        System.out.println("\nTime of running: " + (end - start) + "nanosec");
    }

    //описание функции qSort
    public static void qSort(int[] A, int low, int high) {
        int i = low;
        int j = high;
        int x = A[low+(high-low)/2];
        do {
            while(A[i] < x) ++i;
            while(A[j] > x) --j;
            if(i <= j){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i ++ ;
                j --;
            }
        } while(i <= j);

        //рекурсивные вызовы функции qSort
        if(low < j) qSort(A, low, j);
        if(i < high) qSort(A, i, high);
    }
}
