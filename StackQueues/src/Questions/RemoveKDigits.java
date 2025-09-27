// https://leetcode.com/problems/remove-k-digits/

package Questions;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i=0; i<num.length(); i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(k>0){
            st.pop();
            k--;
        }

        if(st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();
        int zeroIndex = 0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0') zeroIndex++;
            else break;
        }

        return !sb.substring(zeroIndex).isEmpty() ? sb.substring(zeroIndex) : "0";
    }
}
