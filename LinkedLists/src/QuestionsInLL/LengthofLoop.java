// https://www.geeksforgeeks.org/problems/find-length-of-loop/1

package QuestionsInLL;

import java.util.HashMap;
import java.util.Map;

public class LengthofLoop {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    public static int lengthOfLoop(Node head) {
        // BRuteForce
        Map<Node, Integer> mpp = new HashMap<>();
        Node temp = head;
        int timer = 1;

        while (temp != null) {
            if (mpp.containsKey(temp)) {
                return timer - mpp.get(temp);
            }

            mpp.put(temp, timer);
            timer++;
            temp = temp.next;
        }
        return 0;



        // OPTIMAL
//        Node slow = head, fast = head;
//
//        while(fast!=null && fast.next!=null){
        // detect loop first
//            slow = slow.next;
//            fast = fast.next.next;
//
//            if(slow==fast){
//                // now find length
//                int cnt = 1;
//                fast = fast.next;
//
//                while(slow!=fast){
//                    fast = fast.next;
//                    cnt++;
//                }
//                return cnt;
//            }
//        }
//        return 0;
    }
}
