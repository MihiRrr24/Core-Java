// https://leetcode.com/problems/linked-list-cycle/

package QuestionsInLL;

public class LinkListCycleI {
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

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = convert2LL(arr);
        boolean ans = hasCycle(head);
        System.out.println(ans);
    }

    public static boolean hasCycle(ListNode head) {
        // NAIVE APPROACH
        // Map<ListNode, Boolean> mpp = new HashMap<>();
        // ListNode temp = head;

        // while(temp != null){

        //     // check if node is in LL
        //     if(mpp.containsKey(temp)){
        //         return true;
        //     }

        //     mpp.put(temp, true);
        //     temp = temp.next;
        // }
        // return false;




        // OPTIMAL
        ListNode slow=head, fast=head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }
}
