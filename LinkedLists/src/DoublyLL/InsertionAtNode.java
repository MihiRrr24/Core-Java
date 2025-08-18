package DoublyLL;

public class InsertionAtNode {
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







    // Insertion At Head
    public static Node insertionAtHead(Node head, int val){
        Node newNode = new Node(val, head, null);
        head.back = newNode;

        return newNode;
    }

    // Insertion At Tail
    public static Node insertionAtTail(Node head, int val){
        if(head.next == null){
            return insertionAtHead(head, val);
        }

        Node tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        Node prev = tail.back;
        Node newNode = new Node(val, tail, prev);
        tail.back = newNode;
        prev.next = newNode;

        return head;
    }

    // Insertion At Kth Pos
    public static Node insertionAtKth(Node head, int k, int val){
        if(k==1){
            return insertionAtHead(head, val);
        }

        Node kNode = head;
        int cnt = 0;

        while(kNode != null){
            cnt++;
            if(cnt == k) break;

            kNode = kNode.next;
        }

        Node prev = kNode.back;
        Node newNode = new Node(val, kNode, prev);
        prev.next = newNode;
        kNode.back = newNode;

        return head;
    }

    // Insertion At Kth Pos
    public static void insertionAtNode(Node node, int val){
        Node prev = node.back;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.back = newNode;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        Node head = convertArr2DLL(arr);


        // Insertion At Head
//        head = insertionAtHead(head, 10);


        // Insertion At Head
//        head = insertionAtTail(head, 10);


        // Insertion At Kth Node
//        head = insertionAtKth(head, 1, 10);


        // Insertion At Node
        insertionAtNode(head.next.next.next, 10);
        print(head);
    }
}
