

package DoublyLL;

public class ReverseDLL {
    public static class Node {
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
        int[] arr = {12, 14, 16, 18};
        Node head = convertArr2DLL(arr);

        head = reverseDLL(head);
        print(head);
    }

    public static Node reverseDLL(Node head){
        if(head == null || head.next == null) return head;

        // BRUTEFORCE
//        Node temp = head;
//        Stack<Integer> st = new Stack<>();
//
//        while(temp != null){
//            st.add(temp.data);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while (temp != null){
//            temp.data = st.pop();
//            temp = temp.next;
//        }
//
//        return head;






        // OPTIMAL
        Node current = head, prev = null;
        while(current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;

            current = current.back;
        }

        return prev.back;
    }
}
