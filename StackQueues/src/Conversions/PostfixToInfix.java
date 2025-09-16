package Conversions;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println("String : "+str);
        System.out.println("Postfix To Infix : "+postfixToInfix(str));
    }

    public static String postfixToInfix(String s){
        int i=0;
        Stack<String> st = new Stack<>();

        while(i<s.length()){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }

            else {
                String top1 = st.pop();
                String top2 = st.pop();
                st.push('(' + top2 + ch + top1 + ")");
            }
            i++;
        }
        return st.pop();
    }
}
