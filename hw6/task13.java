package hw6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class task13 {
    static HashMap<String, Integer> priorityMap = new HashMap<>();
    static HashSet<String> operation = new HashSet<>();

    static {
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("(", 3);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);

        operation.add("+");
        operation.add("-");
        operation.add("*");
        operation.add("/");
    }

    public static void main(String[] args) {
        String infixForm = "5 + 2 * 4" ;
        String str = postfixFrom(infixForm);
        System.out.println(str);
        String[] tokens = str.split(" ");
        System.out.print(eval(tokens));

    }

    public static String postfixFrom(String infixForm) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] tokens = infixForm.split(" ");

        for (String string : tokens) {
            if ("(".equals(string)) {
                stack.push("(");
            } else if (")".equals(string)) {
                String removed = stack.pop();
                while (!removed.equals("(")) {
                    result.append(removed).append(" ");
                    removed = stack.pop();
                }
            } else if (!operation.contains(string)) {
                result.append(string);
                result.append(" ");
            } else {
                while (!stack.isEmpty() && priorityMap.get(stack.peek()) > priorityMap.get(string)) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(string);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }

        return result.toString().trim();

    }

    public static int eval(String[] tokens) {
        int result = 0;
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        Stack<Integer> nums = new Stack<>();
        for (String token : tokens) {
            if (operation.contains(token)) {
                int second = nums.pop();
                int first = nums.pop();
               
                nums.add(perform(token, first, second));
                result = nums.peek();
                
            } else {
                nums.add(Integer.parseInt(token));
            }
        }
        System.out.println(Arrays.toString(nums.toArray()));
        return result;
    }

    public static int perform(String token, int first, int second) {
        System.out.print(token);
        switch (token) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                return 0;
        }
    }

}