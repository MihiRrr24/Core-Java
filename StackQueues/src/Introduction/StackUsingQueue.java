// https://leetcode.com/problems/implement-stack-using-queues/

package Introduction;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static Queue<Integer> q = new LinkedList<>();

    public static void push(int x){
        int size = q.size();
        q.add(x);

        for (int i=1; i<=size; i++){
            q.offer(q.poll());
        }
    }

    public static void main(String[] args) {
        push(4);
        push(9);
        push(2);
        push(5);
        System.out.println("Top -> "+q.peek());
        q.poll();
        q.poll();
        System.out.println("Top -> "+q.peek());
        push(1);
        System.out.println("Top -> "+q.peek());
    }
}
