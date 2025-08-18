// https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

package QuestionsInLL;

public class SortLL012 {
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
        int[] arr = {1, 0, 1, 2, 0, 2, 1};
        ListNode head = convert2LL(arr);
        head = segregate(head);
        print(head);
    }

    public static ListNode segregate(ListNode head) {
        // BRUTEFORCE
//        int cnt0=0, cnt1=0, cnt2=0;
//        ListNode temp = head;
//        while(temp != null){
//            if(temp.val == 0) cnt0++;
//            else if(temp.val == 1) cnt1++;
//            else cnt2++;
//            temp = temp.next;
//        }
//
//        temp = head;
//        while(temp!=null){
//            if(cnt0 > 0){
//                temp.val = 0;
//                cnt0--;
//            }
//            else if(cnt1 > 0){
//                temp.val = 1;
//                cnt1--;
//            }
//            else{
//                temp.val = 2;
//                cnt2--;
//            }
//
//            temp = temp.next;
//        }
//        return head;








        // OPTIMAL
        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode zero = zeroHead, one = oneHead, two = twoHead;

        ListNode temp = head;

        // traverse now
        while (temp != null){
            if(temp.val == 0){
                zero.next = temp;
                zero = temp;
            }
            else if(temp.val == 1){
                one.next = temp;
                one = temp;
            }
            else{
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        // connect their links
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }
}
