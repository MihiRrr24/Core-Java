// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

package QuestionsInLL;

public class RemoveDuplicatesII {
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
        int[] arr = {1, 1, 2, 3, 3, 4};
        ListNode head = convert2LL(arr);
        head = deleteDuplicates(head);
        print(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // take two ptrs
        ListNode prev = dummy, curr = head;

        while(curr!=null && curr.next!=null){
            if(curr.val == curr.next.val){
                // traverse till non duplicate node
                while(curr.next!=null && curr.val==curr.next.val){
                    curr = curr.next;
                }
                // remove duplicates by pointing
                prev.next = curr.next;
            }
            else{
                prev = prev.next; // move to next element if no duplicates
            }

            curr = curr.next;
        }
        return dummy.next;
    }
}
