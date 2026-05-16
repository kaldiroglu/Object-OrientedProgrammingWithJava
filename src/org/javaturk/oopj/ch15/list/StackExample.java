package org.javaturk.oopj.ch15.list;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackExample {

    public static void main(String[] args) {
//        run1();
//        run2();
//        run3();
//        run4();
        String s = "16 + 5 - 2";
        run5(s);
//
//        s = "16 / 4 * 2";
//        run5(s);
//
//        s = "16 / 4";
//        run5(s);
//        s = " 1 + 2 + 3";
//        run5(s);
    }

    public static void run1() {
        Stack<String> stack = new Stack<>();
        System.out.println("At the beginning");

        System.out.println("Empty? " + stack.empty());
        System.out.println("Size: " + stack.size());

        System.out.println("\nPopulating.");
        System.out.println("Pushing: " + stack.push("one"));
        System.out.println("Pushing: " + stack.push("two"));
        System.out.println("Pushing: " + stack.push("three"));

        System.out.println("\nAfter populating.");
        System.out.println("Size: " + stack.size());

        System.out.println("\nIterating by forEach:");
        stack.forEach(System.out::println);

        System.out.println("\nIterating by iterator:");
        Iterator<String> it = stack.iterator();
        //System.out.println("Pushing: " + stack.push("four")); // ConcurrentModificationException
        while (it.hasNext())
            System.out.println(it.next());

        System.out.println("\nPushing: " + stack.push("four"));
        System.out.println("Index of four: " + stack.indexOf("four"));

        System.out.println("\nIterating by enhanced for:");
        for (String s : stack) System.out.println(s);

        System.out.println("\nPoping: " + stack.pop());
        System.out.println("\nAfter poping.");
        System.out.println("Size: " + stack.size());
        stack.forEach(System.out::println);

        System.out.println("\nPeeking: " + stack.peek());

        System.out.println("\nAfter peeking.");
        System.out.println("Size: " + stack.size());
        stack.forEach(System.out::println);

        System.out.println("\nSearching for two: " + stack.search("two"));

        System.out.println("\nPoping: " + stack.pop());
        System.out.println("\nPeeking: " + stack.peek());

        System.out.println("Size: " + stack.size());
        stack.forEach(System.out::println);

        System.out.println("\nPoping: " + stack.pop());
        System.out.println("\nPeeking: " + stack.peek());

        System.out.println("\nPoping: " + stack.pop());
        System.out.println("\nPeeking: " + stack.peek());
    }

    public static void run2() {
        Stack<String> stack = new Stack<>();
        System.out.println("At the beginning");

        System.out.println("Empty? " + stack.empty());
        System.out.println("Size: " + stack.size());

        System.out.println("\nPopulating:");
        System.out.println("Pushing: " + stack.push("one"));
        System.out.println("Pushing: " + stack.push("two"));
        System.out.println("Pushing: " + stack.push("three"));

        System.out.println("\nSize: " + stack.size());
        stack.forEach(System.out::println);

        System.out.println("\nAdding a list:");
        List<String> list = List.of("four", "five", "six", "seven");
        stack.addAll(list);

        System.out.println("\nSize: " + stack.size());
        stack.forEach(System.out::println);

//        System.out.println("\nPopping:");
//        while (!stack.empty()) { // This way is problem due to infinite loop!
//            String s = stack.peek();
//            if(s.startsWith("t"))
//                System.out.println("Popping: " + stack.pop());
//        }

        System.out.println("\nRemoving elements that starts with 't':");
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            String s = stack.get(i);
            System.out.println("i: " + i + " element: " + s);
            if (s.startsWith("t")) {
                System.out.println("Removing: " + stack.remove(i));
                size = stack.size();
                System.out.println("New size: " + size);
            }
        }

        System.out.println("\nEmpty? " + stack.empty());
        System.out.println("Size: " + stack.size());

        System.out.println("\nIterating by enhanced for:");
        for (String s : stack) System.out.println(s);
    }

    /**
     * Correct use of stack. It reverses a given string.
     */
    public static void run3() {
        String s = "I love Java very much!";
        System.out.println(s);
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            stack.push(c);

        StringBuffer sb = new StringBuffer();
        while (!stack.empty())
            sb.append(stack.pop());
        System.out.println(sb.toString());
    }

    /**
     * Correct use of stack. It checks whether all open parenthesis have been closed.
     */
    public static void run4() {
        String s = "(((((((((((((()))))))))))";
        System.out.println(s);
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars)
            if (c == '(')
                stack.push(c);
            else if (c == ')')
                if (!stack.empty())
                    stack.pop();

        System.out.println("At the end!");
        System.out.println("Is stack empty: " + stack.empty());
    }

    /**
     * Correct use of stack. It is about expression evaluation.
     */
    public static void run5(String expression) {
        double arg1 = 0, arg2 = 0;
        double result = 0.0;
        String operator = null, nextOperator = null;
        String calculation = "op";
        Stack<Double> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(expression);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (isInteger(token)) {
                double arg = Double.parseDouble(token);
                stack.push(arg);
            } else {
                if (stack.size() == 1) {
                    operator = token;
                } else if (stack.size() == 2) {
                    nextOperator = token;
                    arg2 = stack.pop();
                    arg1 = stack.pop();
                    System.out.print("\nCalculating: " + arg1 + " " + operator + " " + arg2);
                    result = calculate(arg1, arg2, operator);
                    System.out.println(" = " + result);
                    stack.push(result);
                    operator = nextOperator;
                }
            }
        }
    }

    private static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double calculate(double arg1, double arg2, String operator) {
        return switch (operator) {
            case "+" -> arg1 + arg2;
            case "-" -> arg1 - arg2;
            case "*" -> arg1 * arg2;
            case "/" -> arg1 / arg2;
            case "pow" -> Math.pow(arg1, arg2);
            default -> -1;
        };
    }
}
