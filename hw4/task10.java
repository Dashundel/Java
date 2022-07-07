package hw4;

/*Реализовать алгоритм перевода из инфиксной записи в постфиксную 
для арифметического выражения.*/

import java.util.Scanner;
import java.util.*;
import java.util.Stack;
import java.lang.Number;

public class task10{
    public static void main(String[] args)
    {
        
        Scanner iScanner = new Scanner(System.in);
        System.out.print("\n Введите выражение: ");
        String expression = iScanner.nextLine();
        iScanner.close();

        String postfix;
        postfix = convertToPostfix(expression);
        
        System.out.print("Постфиксная форм: \n" ); 
        System.out.println(postfix);
        System.out.print("Результат: \n"); 
        operation(postfix);
    } 

    private static int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String convertToPostfix(String infix) {
        Stack<Character> stack = new Stack<Character>();
        String postfix = new String();
        char sym;

        for (int i = 0; i < infix.length(); i++) {
            sym = infix.charAt(i);

            if (sym == '(') stack.push(sym);
            else if (sym == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop().toString();
                }
                if (!stack.isEmpty() && stack.peek() != '(') return null;
                else if(!stack.isEmpty()) stack.pop();
            }
            else if (sym == '+' || sym == '-' || sym == '*' || sym == '/' || sym == '^') {
                if (!stack.isEmpty() && priority(sym) <= priority(stack.peek())) 
                    postfix = postfix + stack.pop().toString();
                
                stack.push(sym);
            }
            else postfix = postfix + sym;      
        }

        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop().toString();
        }
        return postfix;
    }

    public static void operation(String expression)
    {
        int res = 0;
        char[] exp = expression.toCharArray();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < exp.length; i++){
            if(Character.isDigit(exp[i])) st.push(Character.getNumericValue(exp[i]));  
            else{
                switch(exp[i]){
                    case '+':
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case '-':
                        res = st.pop() - st.pop();
                        st.push(res);
                        break;  
                    case '*':
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case '/':
                        res = st.pop() / st.pop();
                        st.push(res);
                        break;      
                    default:
                        break;     
                }
            }
        }
        System.out.printf("%d\n", st.pop());
    } 
}   
