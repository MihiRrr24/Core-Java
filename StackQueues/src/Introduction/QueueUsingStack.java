// https://leetcode.com/problems/implement-queue-using-stacks/

package Introduction;

import java.util.Stack;

public class QueueUsingStack {
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static void push(int x){
        // step 1
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        // step 2
        s1.push(x);

        // step 3
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }

        System.out.println("Pushed "+x);
    }

    public static void main(String[] args) {
        push(4);
        push(2);
        push(3);
        push(5);
        System.out.println();
        System.out.println("Top "+s1.peek());
        System.out.println();
        s1.pop();
        System.out.println();
        push(6);
        System.out.println();
        System.out.println("Top "+s1.peek());
        System.out.println("Size "+s1.size());
    }
}
