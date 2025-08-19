// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

package QuestionsInLL;

public class RemoveDuplicatesI {
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
        ListNode temp = head;
        if(temp==null) return null;

        while(temp.next!=null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        return head;
    }
}
