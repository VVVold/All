package ru.alhorithms.chapter1;


import java.util.Arrays;

public class Brackets {
    private Stack<String> operations = new Stack<>();
    private Stack<String> values = new Stack<>();


    Brackets(String string) {

        String[] s = string.split(" ");

        for (int i = 0; i < s.length; i++) {
            switch (s[i]) {
                case "+":
                    operations.push("+");
                    break;
                case "-":
                    operations.push("-");
                    break;
                case "*":
                    operations.push("*");
                    break;
                case "/":
                    operations.push("-");
                    break;
                case "(":
                    break;
                case ")":
                    String a = values.pop();
                    a = "(" + " " + values.pop() + " " + operations.pop() + " " + a + " " + ")";
                    values.push(a);
                    break;
                default:
                    values.push(s[i]);
                    break;
            }
        }

        System.out.println(values.pop());
    }
}
