package Conversions;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String str = "*+PQ-MN";
        System.out.println("String : "+str);
        System.out.println("Prefix To Infix : "+prefixToInfix(str));
    }

    public static String prefixToInfix(String s){
        int i=s.length()-1;
        Stack<String> st = new Stack<>();

        while (i>=0){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String top1 = st.pop();
                String top2 = st.pop();
                st.push('('+top1+ch+top2+')');
            }
            i--;
        }
        return st.pop();
    }
}
