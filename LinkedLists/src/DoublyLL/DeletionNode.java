package DoublyLL;

public class DeletionNode {
    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data, Node next, Node back) {
            this.data = data;
            this.next = next;
            this.back = back;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
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
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }








    // Deletion At HEAD
    public static Node deletionAtHead(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node prev = head;
        head = head.next;

        head.back = null;
        prev.next = null;

        return head;
    }

    // Deletion At TAIL
    public static Node deletionAtTail(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;
        tail.back = null;
        prev.next = null;

        return head;
    }

    // Deletion At Kth Node
    public static Node deletionAtKthNode(Node head, int k){
        if(head == null) return null;

        // come at kth position
        int cnt = 0;
        Node kNode = head;
        while (kNode != null){
            cnt++;
            if(cnt == k) break;

            kNode = kNode.next;
        }

        // so handle the cases
        Node prev = kNode.back;
        Node front = kNode.next;

        if(prev == null && front == null){
            return null;
        }
        else if(prev == null){
            return deletionAtHead(head);
        }
        else if(front == null){
            return deletionAtTail(head);
        }


        prev.next = front;
        front.back = prev;

        kNode.back = null;
        kNode.next = null;
        return head;
    }

    // Deletion at Node
    public static void deletionAtNode(Node temp){
        Node prev= temp.back;
        Node front = temp.next;

        // last element
        if(front == null){
            prev.next = null;
            temp.back = null;
            return;
        }

        // in between elements case
        prev.next = front;
        front.back = prev;

        temp.next = temp.back = null;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        Node head = convertArr2DLL(arr);


        // deletion at head
//        head = deletionAtHead(head);


        // deletion at tail
//        head = deletionAtTail(head);


        // deletion at Kth Element
//        head = deletionAtKthNode(head, 4);


        // Deletion at Node
        deletionAtNode(head.next.next.next);
        print(head);
    }
}
