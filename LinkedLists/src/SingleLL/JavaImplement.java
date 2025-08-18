package SingleLL;

public class JavaImplement {
    static class Node {
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

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};
        Node x = new Node(arr[4]);
        System.out.println(x.data);
        System.out.println(x.next);

    }
}


