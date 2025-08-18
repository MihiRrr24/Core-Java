// https://leetcode.com/problems/sort-list/

package QuestionsInLL;

public class sortLL {
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
        int[] arr = {3, 4, 2, 1, 5};
        ListNode head = convert2LL(arr);
        head = sortList(head);
        print(head);
    }


    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        // BRUTEFORCE
//        ArrayList<Integer> list = new ArrayList<>();
//        ListNode temp = head;
//
//        while (temp != null){
//            list.add(temp.val);
//            temp = temp.next;
//        }
//
//        Collections.sort(list);
//
//        int i=0;
//        temp = head;
//        while(temp != null){
//            temp.val = list.get(i);
//            i++;
//            temp = temp.next;
//        }
//        return head;









        // OPTIMAL
        ListNode middle = findMiddle(head);
        ListNode leftHead = head, rightHead = middle.next;
        middle.next = null;

        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return merge2List(leftHead, rightHead);
    }

    public static ListNode findMiddle(ListNode head){
        ListNode slow = head, fast = head;
//        ListNode fast = head.next; (will work in normal while conditions)

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode merge2List(ListNode head1, ListNode head2){
        ListNode dummy  = new ListNode(-1);
        ListNode t1 = head1, t2 = head2, temp = dummy;

        while(t1 != null && t2 != null){
            if(t1.val <= t2.val){
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            }
            else{
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null){
            temp.next = t1;
        }
        else{
            temp.next = t2;
        }

        return dummy.next;
    }
}
