package ru.alhorithms.chapter1;


import java.util.Random;

public class Interval1D {
    Random random = new Random();


    Interval1D(int N) {
        float [] a = new float[N];
        float [] b = new float[N];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextFloat();
            b[i] = random.nextFloat();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i +  1; j < N; j++) {
                if (a[j] > a[i] && a[j] < b[i]) System.out.println("Пересекающиеся интервалы " + (i + 1) + " и " + (j + 1));
            }
        }
    }
}
