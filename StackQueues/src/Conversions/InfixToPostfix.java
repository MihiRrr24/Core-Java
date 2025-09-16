// https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1

package Conversions;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String str = "a+b)";
        System.out.println("String : "+str);
        System.out.println("Infix To Postfix : "+infixToPostfix(str));
    }

    public static String infixToPostfix(String s){
        int i=0, n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        while (i < n){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                ans.append(ch);
            }

            else if(ch == '('){
                st.push(ch);
            }

            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }

                if(!st.isEmpty() && st.peek() == '(') st.pop();
            }

            else {
                while (!st.isEmpty() &&
                        precedence(ch) <= precedence(st.peek())){
                    ans.append(st.pop());
                }
                st.push(ch);
            }

            i++;
        }

        // the left over
        while (!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static int precedence(char c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
