// https://leetcode.com/problems/middle-of-the-linked-list/

package QuestionsInLL;

public class MiddleOfLL {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode convert2LL(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for(int i=1; i<arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);
            mover.next = newNode;
            mover = newNode;
        }
        return head;
    }
    public static void print(ListNode head){
        while(head != null){
            System.out.println(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = convert2LL(arr);
        head = middleNode(head);
        print(head);
    }

    public static ListNode middleNode(ListNode head) {
        // BruteForce
//        ListNode temp = head;
//        int count = 0;
//
//        while(temp != null){
//            count++;
//            temp = temp.next;
//        }
//
//        int midNode =  ( (count / 2) + 1);
//        temp = head;
//        while(midNode != 0){
//            midNode--;
//            if(midNode != 0) temp = temp.next;
//        }
//
//        return temp;




        // OPTIMAL (Tortoise and Hare)
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
