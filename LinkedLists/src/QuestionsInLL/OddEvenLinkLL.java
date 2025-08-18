// https://leetcode.com/problems/odd-even-linked-list/

package QuestionsInLL;

public class OddEvenLinkLL {
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
        head = oddEvenList(head);
        print(head);
    }


    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        // BRUTEFORCE
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode temp = head;
//
//        // odd indices
//        while(temp!=null && temp.next!=null){
//            list.add(temp.val);
//            temp=temp.next.next;
//        }
//        if(temp != null){           // check for last element in odd length case
//            list.add(temp.val);
//        }
//
//
//        // even indices
//        temp = head.next;
//        while(temp!=null && temp.next!=null){
//            list.add(temp.val);
//            temp=temp.next.next;
//        }
//        if(temp != null){           // check for last element in odd length case
//            list.add(temp.val);
//        }
//
//
//
//        // replace the values in LL
//        int i=0;
//        temp = head;
//        while (temp != null){
//            temp.val = list.get(i);
//            i++;
//            temp = temp.next;
//        }
//
//        return head;





        // OPTIMAL
        ListNode odd = head, even = head.next, evenHead = head.next;

        while (even!=null && even.next!=null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even=even.next;
        }

        // point the odd end to even start
        odd.next = evenHead;
        return head;
    }
}
