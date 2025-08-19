// https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1

package QuestionsInDLL;

public class DeleteOccOfKey {
    public static class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            next = prev = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i=1; i<arr.length; i++){
            Node newNode = new Node(arr[i], null, prev);
            prev.next = newNode;
            prev = newNode;
        }
        return head;
    }

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 10 , 10, 6, 10};
        Node head = convertArr2DLL(arr);

        head = deleteAllOccurOfX(head, 10);
        print(head);
    }

    public static Node deleteAllOccurOfX(Node head, int x) {
        Node temp = head;
        while(temp != null){

            if(temp.data == x){
                // handle head case
                if(temp == head){
                    head = head.next;
                }
                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                // in between cases
                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;

                // last step
                temp = nextNode;
            }

            else temp = temp.next;
        }

        return head;
    }
}
