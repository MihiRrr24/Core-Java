// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package QuestionsInLL;

public class RemoveNthNode {
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
        int[] arr = {3,2,0,-4};
        ListNode head = convert2LL(arr);
        head = removeNthFromEnd(head, 2);
        print(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        // BRUTEFORCE
//        int cnt = 0;
//        ListNode temp = head;
//        while(temp != null){
//            cnt++;
//            temp = temp.next;
//        }
//        // check if we gotta delete head (think from end)
//        if(cnt == n){
//            return head.next;
//        }
//
//
//        // now traverse to the previous of nth node
//        int res = cnt-n;
//        temp = head;
//        while(temp != null){
//            res--;
//            if(res==0) break;
//            temp = temp.next;
//        }
//        // change the links
//        temp.next = temp.next.next;
//        return head;








        // OPTIMAL
        ListNode fast = head;
        for(int i=0; i<n; i++){
            fast = fast.next;
        }
        // check head
        if(fast == null) return head.next;

        // traverse till nth previous node
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
