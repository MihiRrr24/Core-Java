// https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1

package QuestionsInDLL;

public class RemoveDuplicatesFromDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3, 4};
        Node head = convertArr2DLL(arr);
        head = removeDuplicates(head);
        print(head);
    }


    public static Node removeDuplicates(Node head) {
        Node temp = head;

        while(temp!=null && temp.next!=null){
            //place the nextNode
            Node nextNode = temp.next;

            // move till dupicates are found
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }

            // point temp to non duplicate value
            temp.next = nextNode;
            if(nextNode != null) nextNode.prev = temp;

            temp = temp.next;
        }
        return head;
    }

}
