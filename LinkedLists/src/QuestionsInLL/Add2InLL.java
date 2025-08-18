package QuestionsInLL;

public class Add2InLL {
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
        int[] arr2 = {9};
        ListNode headA = convert2LL(arr);
        ListNode headB = convert2LL(arr2);
        ListNode headC = addTwoNumbers(headA, headB);
        print(headC);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode dummyNode = new ListNode(-1) , curr = dummyNode;
        int carry = 0;

        while(temp1 != null || temp2 != null){
            int sum = carry;

            // now add if there
            if(temp1 != null) sum += temp1.val;
            if(temp2 != null) sum += temp2.val;

            // create new Node and take carry
            ListNode newNode  = new ListNode(sum%10);
            carry = sum / 10;

            // point curr to newNode
            curr.next = newNode;

            curr = curr.next;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }

        if(carry != 0){
            ListNode newNode  = new ListNode(carry);
            curr.next = newNode;
        }

        return dummyNode.next;
    }
}
