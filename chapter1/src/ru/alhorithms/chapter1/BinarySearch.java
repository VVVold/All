package ru.alhorithms.chapter1;


public class BinarySearch {
    int N;
    BinarySearch(int[] array, int key) {
        System.out.println(search(array, key, 0, array.length - 1));
    }

    int search (int[] array, int key, int low, int hi) {
        int half = low + (hi - low) / 2;
        if (key > array[half]) return search(array, key, half + 1, hi);
        else if (key < array[half]) return search(array, key, 0, half);
        else if (key == array[half]) return half;
        else return -1;
    }
}
