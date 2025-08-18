// https://leetcode.com/problems/reverse-linked-list/

package QuestionsInLL;

public class ReverseLL {
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
        head = reverseList(head);
        print(head);
    }

    public static ListNode reverseList(ListNode head) {
        // BruteForce
//        ListNode temp = head;
//        Stack<Integer> st = new Stack<>();
//
//        while(temp != null){
//            st.push(temp.val);
//            temp = temp.next;
//        }
//
//        temp=head;
//        while(temp!=null){
//            temp.val = st.pop();
//            temp = temp.next;
//        }
//
//        return head;



        // OPTIMAL
        ListNode temp = head, prev = null;
        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;

            // update prev and temp
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
