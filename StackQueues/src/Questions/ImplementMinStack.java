// https://leetcode.com/problems/min-stack/

package Questions;

import java.util.Stack;

public class ImplementMinStack {
//    public static class Pair<U, V>{
//        public final U first;
//        public final V second;
//
//        public Pair(U first, V second){
//            this.first = first;
//            this.second = second;
//        }
//    }

    private static Stack<Long> st;
    private static Long mini;

    public ImplementMinStack(){
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }

    public static void push(int x){
        Long val = Long.valueOf(x);
        if(st.isEmpty()){
            mini = val;
            st.push(val);
        }
        else{
            if(val < mini){
                st.push(2*val - mini);
                mini = val;
            }
            else{
                st.push(val);
            }
        }
    }

    public static void pop(){
        if(st.isEmpty()) return;

        Long val = st.pop();
        if(val < mini){
            mini = 2*mini - val;
        }
    }

    public static int top(){
        Long val = st.peek();
        if(val < mini){
            return mini.intValue();
        }
        return val.intValue();
    }

    public static int getMin(){
        return mini.intValue();
    }

    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();
//        Stack<Pair<Integer, Integer>> st = new Stack<>();



        ImplementMinStack im = new ImplementMinStack();
        push(12);
        push(15);
        push(10);
        System.out.println("Current Min: " + getMin());
        pop();
        System.out.println("Top: " + top());
        System.out.println("Current Min: " + getMin());
    }

//    public static void push(Stack<Pair<Integer, Integer>> st, int x){
    // Better
//        if(st.isEmpty()){
//            st.push(new Pair<>(x, x));
//        }
//        else{
//            int mini = Math.min(x, st.peek().second);
//            st.push(new Pair<>(x, mini));
//        }
//  }

//    public static int getMin(Stack<Pair<Integer, Integer>> s){
        // Bruteforce
//        int mini = Integer.MAX_VALUE;
//        Stack<Integer> temp = new Stack<>();
//
//        while (!s.isEmpty()){
//            int val = s.pop();
//            mini = Math.min(mini, val);
//            temp.push(val);
//        }
//        while (!temp.isEmpty()){
//            s.push(temp.pop());
//        }
//        return mini;


        // Better
//        return s.peek().second;
//    }
}
