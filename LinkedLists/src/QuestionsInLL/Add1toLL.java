// https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1

package QuestionsInLL;

public class Add1toLL {
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
        int[] arr = {9,9,9,9};
        ListNode head = convert2LL(arr);
        head = addOne(head);
        print(head);
    }


    public static ListNode addOne(ListNode head) {
        // One way
//        head = reverseList(head);
//        ListNode temp = head;
//        int carry = 1;
//
//        while (temp != null){
//            temp.val = temp.val + carry;
//
//            // handle the normal and carry case
//            if(temp.val < 10){
//                carry = 0;
//                break;
//            }
//            else {
//                temp.val = 0;
//            }
//
//            temp = temp.next;
//        }
//
//        if(carry == 1){
//            ListNode newNode = new ListNode(1);
//            head = reverseList(head);
//            newNode.next = head;
//            return newNode;
//        }
//
//        // normal if no carry is there
//        head = reverseList(head);
//        return head;









        // 2nd way (Recursion)
        int carry = helperFunc(head);
        if(carry == 1){
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            return newNode;
        }
        return head;
    }

    public static ListNode reverseList(ListNode head){
        ListNode temp = head, prev = null;

        while(temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static int helperFunc(ListNode temp){
        if(temp == null) return 1;
        int carry = helperFunc(temp.next);

        temp.val += carry;

        if(temp.val < 10) return 0;
        temp.val = 0;
        return 1;
    }
}
