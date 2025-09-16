package Conversions;

import java.util.Stack;

public class InfixToPrefix {
    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";
        System.out.println("String : "+str);
        System.out.println("Infix To Prefix : "+infixToPrefix(str));
    }

    public static String infixToPrefix(String s){
        // Step 1 -> reversse the infix String
        s = reverse(s);

        // step 2 -> infix to postfix with some changes
        String ans = infixToPostfix(s);

        // step 3 reverse str and return
        return reverse(ans);
    }

    public static String reverse(String str){
        char[] res = str.toCharArray();
        int i=0, j= res.length-1;
        while(i<j){
            char temp = res[i];
            res[i] = res[j];
            res[j] = temp;
            i++;
            j--;
        }


        // swap brackets
        for(int k = 0; k< res.length; k++){
            if(res[k] == '(') res[k] = ')';
            else if(res[k] == ')') res[k] = '(';
        }

        return new String(res);
    }

    public static String infixToPostfix(String s){
        int i=0;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        while (i < s.length()){
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
                if(ch == '^') {
                    while (!st.isEmpty() &&
                            precedence(ch) <= precedence(st.peek())) {
                        ans.append(st.pop());
                    }
                }
                else{
                    while (!st.isEmpty() &&
                            precedence(ch) < precedence(st.peek())) {
                        ans.append(st.pop());
                    }
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
