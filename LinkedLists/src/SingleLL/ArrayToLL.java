package SingleLL;

class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data1) {
        this.data = data1;
        this.next = null;
    }
}

public class ArrayToLL {
    private static Node convert2ArrLL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;     // or mover.next
        }

        return head;
    }

    private static int lengthOfLL(Node head){
        Node temp = head;
        int count = 0;

        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static int searchInLL(Node head, int key){
        Node temp = head;

        while (temp != null){
            if(temp.data == key) return 1;
            temp = temp.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 16, 18};
        Node head = convert2ArrLL(arr);
        System.out.println(head.data);



        // Traversal OF LL
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();


        // Length of LL
        System.out.println("Length of LinkedList -> "+lengthOfLL(head));

        // Search in LL
        int k = 13;
        System.out.println("Searching in LL "+k+" -> "+searchInLL(head, k));
    }
}
