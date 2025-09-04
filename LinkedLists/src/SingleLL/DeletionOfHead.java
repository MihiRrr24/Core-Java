package SingleLL;

public class DeletionOfHead {
    public static class Node{
        int data;
        Node next;

        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node convertArr(int[] arr){
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i<arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void print(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }



    // deletion from head
    public static Node deleteFromHead(Node head){
        if(head == null) return null;
        head = head.next;
        return head;

        // garbage collect automatically takes care of initial head
    }



    // deletion from tail
    public static Node deleteFromTail(Node head){
        // empty or single element
        if(head == null || head.next == null) return null;

        // 2 or more elements
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }



    // deletion from Kth position
    // https://www.geeksforgeeks.org/problems/remove-every-kth-node/1
    public static Node removeK(Node head, int k){
        // empty LL
        if(head == null) return null;

        // K==1 i.e. head element
        if(k==1){
            head = head.next;
            return head;
        }

        // k== 2 or tail element
        Node temp = head, prev = null;
        int count = 0;

        while (temp != null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }

            prev=temp;
            temp = temp.next;
        }

        return head;             // k is greater
    }



    // deletion of Kth value
    public static Node removeElement(Node head, int value){
        // empty LL
        if(head == null) return null;

        // K==1 i.e. head element
        if(head.data==value){
            head = head.next;
            return head;
        }

        // k== 2 or tail element
        Node temp = head, prev = null;

        while (temp != null){
            if(temp.data == value){
                prev.next = prev.next.next;
                break;
            }

            prev=temp;
            temp = temp.next;
        }

        return head;             // k is greater
    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 16, 18};
        Node head = convertArr(arr);
//        System.out.println(head.data);

        // deletion from head
//        head = deleteFromHead(head);


        // deletion from tail
        head = deleteFromTail(head);


        // deletion from position
//        int k = 2;
//        head = removeK(head, k);


        // deletion from value
//        head = removeElement(head, 16);
        print(head);
    }
}
