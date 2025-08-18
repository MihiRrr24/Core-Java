package DoublyLL;

public class JavaImplement {
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

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
        Node head = convertArr2DLL(arr);
        print(head);
    }
}

