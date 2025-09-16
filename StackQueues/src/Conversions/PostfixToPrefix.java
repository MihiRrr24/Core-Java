package Conversions;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println("String : "+str);
        System.out.println("Postfix To Prefix : "+postfixToPrefix(str));
    }

    public static String postfixToPrefix(String s){
        int i=0;
        Stack<String> st = new Stack<>();

        while (i<s.length()){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(String.valueOf(ch));
            }
            else{
                String top1 = st.pop();
                String top2 = st.pop();
                st.push(ch+top2+top1);
            }
            i++;
        }
        return st.pop();
    }
}
