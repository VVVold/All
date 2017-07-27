package ru.alhorithms.chapter1;

import java.util.Arrays;
import java.util.Random;

public class Point2D {
    Random random = new Random();


    Point2D(int N) {
        double length;
        double min = 1;
        float [] a = new float[N + 1];
        float [] b = new float[N + 1];
        for (int i = 0; i < N; i++) {
            a[i] = random.nextFloat();
            b[i] = random.nextFloat();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                length = Math.sqrt(Math.pow((a[i] - a[j]), 2) + Math.pow(b[i] - b[j], 2));
//                System.out.println(length);
                if (min > length) {
                    min = length;
                    a[N] = i;
                    b[N] = j;

                }
            }
        }
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
        System.out.println("Минимальная длина: " + min + " между точками " + (int)(a[N] + 1) + " и " + (int)(b[N] + 1));

    }
}
