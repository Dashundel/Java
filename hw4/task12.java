package hw4;

//Написать программу, определяющую правильность расстановки скобок в выражении.

import java.util.*;
import java.util.Scanner;
  
public class task12 {

    public static void main(String[] args)
    {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\n Введите выражение: ");
        String expression = iScanner.nextLine();
        iScanner.close();

        if (checkBrackets(expression))
            System.out.println("Истина ");
        else
            System.out.println("Ложь");
    }
  
    static boolean checkBrackets(String exp)
    {
        Deque<Character> deque = new ArrayDeque<Character>();

        for (int i = 0; i < exp.length(); i++){
            char x = exp.charAt(i);
            if (x == '(' || x == '[' || x == '{'|| x == '<') {
                deque.push(x);
            }
            
            //if (deque.isEmpty()) return false;
            char check;
            switch (x) {
                case ')':
                    check = deque.pop();
                    if (check == '{' || check == '['|| check == '<')
                        return false;
                    break;
    
                case '}':
                    check = deque.pop();
                    if (check == '(' || check == '['|| check == '<')
                        return false;
                    break;
    
                case ']':
                    check = deque.pop();
                    if (check == '(' || check == '{'|| check == '<')
                        return false;
                    break;
                    
                case '>':
                    check = deque.pop();
                    if (check == '(' || check == '{'|| check == '[')
                        return false;
                    break;    
            }

        }
        return (deque.isEmpty());
    }
  
   
}

/*
public class MainRun {
    public static void main(String[] args) {

        HashMap<String, Integer> openBrackets = new HashMap<String, Integer>() {{
            put("{", 0);
            put("[", 1);
            put("(", 2);
        }};
        HashMap<String, Integer> closeBrackets = new HashMap<String, Integer>() {{
            put("}", 0);
            put("]", 1);
            put(")", 2);
        }};

       // String brackets = "{a,},(b,),[c,], {";
       // String brackets = "{";
        String brackets = "[,]},{";
        boolean validate = validate(openBrackets, closeBrackets, brackets);

        if(validate) {
            System.out.println("Скобки расставлены правильно.");
        } else {
            System.out.println("Скобки расставлены не правильно.");
        }

    }

    public class ValidationBrackets {


    public static boolean validate( HashMap<String, Integer> openBrackets,
                             HashMap<String, Integer> closeBrackets,
                             String brackets){

        String[] strings = brackets.split(",");

        Deque<String> stack = new ArrayDeque<>();

        for (String inLine: strings) {

            for (int i = 0; i < inLine.length(); i++) {

                char character = inLine.charAt(i);
                String symbol = Character.toString(character);

                if (openBrackets.containsKey(symbol)) {
                    stack.push(symbol);
                } else if (closeBrackets.containsKey(symbol)) {

                    if(!stack.isEmpty()) {

                        Integer ordinalNumberForCheckedSymbol = closeBrackets.get(symbol);

                        String firstElemFromStack = stack.pop();
                        Integer ordinalLastAddedNumberElemFromStack = openBrackets.get(firstElemFromStack);
                        boolean isPairTheBrackets =
                                ordinalLastAddedNumberElemFromStack.equals(ordinalNumberForCheckedSymbol);

                        if(isPairTheBrackets) break;
                    }


                  return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
 */