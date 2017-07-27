package ru.alhorithms.chapter1;


class CyclicShift {
    CyclicShift(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(t.substring(i, t.length()) + t.substring(0, i)) == 0 ) System.out.println(true);
        }
    }
}
