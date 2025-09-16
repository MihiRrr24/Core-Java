package Conversions;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String str = "/-AB*+DEF";
        System.out.println("String : "+str);
        System.out.println("Prefix To Postfix : "+prefixToPostfix(str));
    }

    public static String prefixToPostfix(String s){
        int i = s.length()-1;
        Stack<String> st = new Stack<>();

        while(i >= 0){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String top1 = st.pop();
                String top2 = st.pop();
                st.push(top1+top2+ch);
            }
            i--;
        }
        return st.pop();
    }
}
