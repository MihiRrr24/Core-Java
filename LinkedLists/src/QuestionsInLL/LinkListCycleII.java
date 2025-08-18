// https://leetcode.com/problems/linked-list-cycle-ii/

package QuestionsInLL;

public class LinkListCycleII {
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
        int[] arr = {3,2,0,-4};
        ListNode head = convert2LL(arr);
        head = detectCycle(head);
        print(head);
    }

    public static ListNode detectCycle(ListNode head) {
        // BruteForce
//        Map<ListNode, Boolean> mpp = new HashMap<>();
//        ListNode temp = head;
//
//        while(temp != null){
//            if(mpp.containsKey(temp)){
//                return temp;
//            }
//
//            mpp.put(temp, true);
//            temp = temp.next;
//        }
//        return null;


        // Optimal
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            //step 1
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                // step 2
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
}
