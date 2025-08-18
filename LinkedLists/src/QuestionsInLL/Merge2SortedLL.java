// https://leetcode.com/problems/merge-two-sorted-lists/

package QuestionsInLL;

public class Merge2SortedLL {
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
        int[] arr = {2, 4, 8, 10};
        int[] arr2 = {1, 3, 3, 6, 11, 14};
        ListNode head1 = convert2LL(arr);
        ListNode head2 = convert2LL(arr2);
        ListNode head = mergeTwoLists(head1, head2);
        print(head);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // BRUTEFORCE
        // Step 1: Count the total number of elements
//        int count = 0;
//        ListNode temp1 = list1;
//        ListNode temp2 = list2;
//
//        while (temp1 != null) {
//            count++;
//            temp1 = temp1.next;
//        }
//        while (temp2 != null) {
//            count++;
//            temp2 = temp2.next;
//        }
//
//        // Handle the edge case of empty lists
//        if (count == 0) {
//            return null;
//        }
//
//
//
//        int[] arr = new int[count];
//        temp1 = list1;
//        temp2 = list2;
//
//        // traverse and add elements in array
//        int i=0;
//        while (temp1 != null){
//            arr[i++] = temp1.val;
//            temp1 = temp1.next;
//        }
//
//        while (temp2 != null){
//            arr[i++] = temp2.val;
//            temp2 = temp2.next;
//        }
//
//        // sort the array
//        Arrays.sort(arr);
//
//        // convert the arr back to LL
//        return convert2LL(arr);







        // OPTIMAL
        ListNode dummyNode = new ListNode(-1);
        ListNode t1 = list1, t2 = list2, temp = dummyNode;

        while(t1!=null && t2!=null){
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

        if(t1 != null) temp.next = t1;
        else temp.next = t2;

        return dummyNode.next;
    }
}
