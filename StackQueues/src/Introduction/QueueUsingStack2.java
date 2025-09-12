// https://leetcode.com/problems/implement-queue-using-stacks/

package Introduction;

import java.util.Stack;

public class QueueUsingStack2 {
    public static Stack<Integer> s1 = new Stack<>();
    public static Stack<Integer> s2 = new Stack<>();

    public static void push(int x){
        s1.push(x);
        System.out.println("Pushed "+x);
    }

    public static int pop(){
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public static int peek(){
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public static void main(String[] args) {
        push(2);
        push(3);
        push(4);
        push(5);
        System.out.println();

        System.out.println("Top "+peek());
        System.out.println("Top "+peek());
        System.out.println();

        System.out.println("Pop "+pop());
        System.out.println();

        push(1);
        System.out.println();

        System.out.println("Pop "+pop());
        System.out.println("Pop "+pop());
        System.out.println("Pop "+pop());
        System.out.println();

        System.out.println("Top "+peek());
        System.out.println();

        System.out.println("Pop "+pop());
        System.out.println();

        System.out.println("Top "+peek());
        System.out.println("Size "+s1.size());
    }
}
