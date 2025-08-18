//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

package QuestionsInLL;

public class DeleteTheMiddle {
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
        int[] arr = {3, 0,-4};
        ListNode head = convert2LL(arr);
        head = deleteMiddle(head);
        print(head);
    }


    public static ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null) return null;

        // BRUTEFORCE
//        int len = 0;
//        ListNode temp = head;
//        while(temp != null){
//            len++;
//            temp = temp.next;
//        }
//
//        int res = len/2;
//        temp = head;
//        while(temp != null){
//            res--;
//
//            if(res == 0){
//                temp.next = temp.next.next;
//                break;
//            }
//            temp = temp.next;
//        }
//        return head;





        // OPTIMAL
        ListNode slow = head, fast = head;
        fast = fast.next.next;
        while(fast!=null && fast.next!=null){

            // MY APPROACH
//        while(fast.next.next!=null && fast.next.next.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
