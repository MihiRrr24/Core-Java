// https://leetcode.com/problems/intersection-of-two-linked-lists/

package QuestionsInLL;

public class IntersectingPoints {
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
        int[] arr = {3, 0,-4};
        int[] arr2 = {3, 2, 0, -4};
        ListNode headA = convert2LL(arr);
        ListNode headB = convert2LL(arr2);
        headA = getIntersectionNode(headA, headB);
        print(headA);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        // BRUTEFORCE
//        Map<ListNode, Integer> mpp = new HashMap<ListNode, Integer>();
//        ListNode temp = headA;
//
//        while(temp != null){
//            mpp.put(temp, 1);
//            temp = temp.next;
//        }
//
//        temp = headB;
//
//        while (temp != null){
//            if(mpp.containsKey(temp)){
//                return temp;
//            }
//            temp = temp.next;
//        }
//
//        return null;





        // BETTER
//        ListNode t1 = headA, t2= headB;
//        int n1=0, n2=0;
//
//        while(t1 != null){
//            n1++;
//            t1 = t1.next;
//        }
//        while(t2 != null){
//            n2++;
//            t2 = t2.next;
//        }
//
//        if(n1 < n2){
//            return collisionPoint(headA, headB, n2-n1);
//        }
//        else{
//            return collisionPoint(headB, headA, n1-n2);
//        }







        //OPTIMAL
        ListNode temp1 = headA, temp2= headB;
        while(temp1 != temp2){
//            if(temp1 == temp2) return temp1;          // optional

            temp1 = (temp1 == null) ? headB : temp1.next;
            temp2 = (temp2 == null) ? headA : temp2.next;
        }
        return temp1;

    }

    public static ListNode collisionPoint(ListNode t1, ListNode t2, int d){
        while(d>0){
            d--;
            t2 = t2.next;
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1;
    }
}
