// https://leetcode.com/problems/reverse-nodes-in-k-group/

package QuestionsInLL;

public class ReverseLLInKGroup {
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
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = convert2LL(arr);
        head = reverseKGroup(head, 2);
        print(head);
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null){
            ListNode kNode = getKNode(temp, k);
            if(kNode == null){
                // think of group not forming case
                if(prevLast != null) prevLast.next = temp;
                break;
            }

            // break and reverse the groups
            ListNode nextNode = kNode.next;
            kNode.next = null;
            reverse(temp);

            // if its first group
            if(temp == head){
                head = kNode;
            }
            else{           // if not
                prevLast.next = kNode;
            }

            // move prev and temp for every group
            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }

    public static ListNode getKNode(ListNode temp, int k){
        k -= 1;
        while(temp != null && k>0){
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverse(ListNode head){
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
