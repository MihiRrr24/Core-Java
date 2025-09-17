// https://leetcode.com/problems/valid-parentheses/

package Questions;

import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' ||
                    s.charAt(i) == '{' ||
                    s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }

            else{
                if(st.isEmpty()) return false;
                char ch  = st.pop();
                if(ch == '(' && s.charAt(i) != ')' ||
                        ch == '{' && s.charAt(i) != '}' ||
                        ch == '[' && s.charAt(i) != ']')
                {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }
}
