package ru.alhorithms.chapter1;

public class Dextra2St {
    private Stack<Character> operations = new Stack<>();
    private Stack<Double> values = new Stack<>();


    Dextra2St(String string) {

        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '+':
                    operations.push('+');
                    break;
                case '-':
                    operations.push('-');
                    break;
                case '*':
                    operations.push('*');
                    break;
                case '/':
                    operations.push('/');
                    break;
                case '(':
                    break;
                case ')':
                    double a = values.pop();
                    char c = operations.pop();
                    switch (c) {
                        case '+':
                            a = values.pop() + a;
                            values.push(a);
                            break;
                        case '-':
                            a = values.pop() - a;
                            values.push(a);
                            break;
                        case '*':
                            a = values.pop() * a;
                            values.push(a);
                            break;
                        case '/':
                            a = values.pop() / a;
                            values.push(a);
                            break;
                    }

                    break;
                default:
                    values.push((double)chars[i] - 48);
                    break;
            }
        }
        System.out.println(values.pop());
    }
}
