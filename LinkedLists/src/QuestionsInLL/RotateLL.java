// https://leetcode.com/problems/rotate-list/

package QuestionsInLL;

public class RotateLL {
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
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = convert2LL(arr);
        head = rotateRight(head, 2);
        print(head);
    }


    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // find tail and length
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            len++;
            temp = temp.next;
        }

        // point tail to head
        ListNode tail = temp;
        tail.next = head;

        // reach the new Head
        k = k%len;
        temp = head;
        int stepsToNewHead  = 0;
        while(temp!=null){
            stepsToNewHead++;
            if( stepsToNewHead == (len-k) ) break;

            temp = temp.next;
        }

        // points the new head and also handle null
        head = temp.next;
        temp.next = null;
        return head;
    }
}
