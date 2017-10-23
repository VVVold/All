package ru.alhorithms.chapter3;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        int N = 100000;

        long start = System.currentTimeMillis();
        BinarySearchST<Integer, Integer> st = new BinarySearchST<>(1);
        for (int i = 0; i < N; i++) {
            st.put(i, i);
            st.get(i);
        }
        long BSST = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        BinarySearchST<Integer, Integer> st13 = new BinarySearchST<>(N);
        for (int i = 0; i < N; i++) {
            st13.put(i, i);
            st13.get(i);
        }
        long BSST1 = System.currentTimeMillis() - start;


        start = System.currentTimeMillis();
        SequentialSearchST<Integer, Integer> st1 = new SequentialSearchST<>();
        for (int i = 0; i < N; i++) {
            st1.put(i, i);
            st1.get(i);
        }
        long SSST = System.currentTimeMillis() - start;

        System.out.println(BSST);
        System.out.println(BSST1);
        System.out.println(SSST);







    }
}
