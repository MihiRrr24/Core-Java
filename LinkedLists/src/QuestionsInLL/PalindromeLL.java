// https://leetcode.com/problems/palindrome-linked-list/

package QuestionsInLL;

public class PalindromeLL {
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
        int[] arr = {1, 2, 3, 3, 2, 1};
        ListNode head = convert2LL(arr);
        boolean ans = isPalindrome(head);
        System.out.println(ans);
    }


    public static boolean isPalindrome(ListNode head) {
        // BruteForce
//        Stack<Integer> st = new Stack<>();
//        ListNode temp = head;
//
//        while (temp != null){
//            st.push(temp.val);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp != null){
//            if(temp.val != st.peek()) return false;
//
//            st.pop();
//            temp = temp.next;
//        }
//        return true;



        // OPTIMAL
        // step 1
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        // step 2
        ListNode newHead = reverseLL(slow.next);

        //step 3
        ListNode first = head, second = newHead;
        while (second != null){
            // compare
            if(first.val != second.val){
                reverseLL(newHead);
                return false;
            }

            first = first.next;
            second = second.next;
        }

        reverseLL(newHead);
        return true;
    }

    public static ListNode reverseLL(ListNode head){
        ListNode temp = head, prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}
