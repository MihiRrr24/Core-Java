package SingleLL;

public class InsertionOfHead {
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




    // insertion At Head
    public static Node insertAtHead(Node head, int value){
        Node temp = new Node(value, head);
        return temp;
    }

    // insertion At Last
    public static Node insertionAtLast(Node head, int value){
        if(head == null){
            return new Node(value);
        }

        // traverse till last element
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        // reached last element then
        Node newNode = new Node(value);
        temp.next = newNode;


        return head;
    }



    // insertion at Kth position of element
    public static Node insertionAtK(Node head, int ele, int k){
        // empty LL
        if(head == null){
            if(k==1) return new Node(ele);
            else return null;
        }

        // insert at 1st pos
        if(k == 1){
            return new Node(ele, head);
        }

        // in between insertion
        Node temp = head;
        int count = 0;

        while(temp != null){
            count++;

            if(count == k-1){
                Node newNode = new Node(ele, temp.next);
//                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }

            temp = temp.next;
        }
        return head;
    }





    // insertion at before Value
    public static Node insertionBeforeValue(Node head, int ele, int val){
        // empty LL
        if(head == null) return null;

        // insert at 1st pos
        if(head.data == val){
            return new Node(ele, head);
        }

        // in between insertion
        Node temp = head;

        while(temp.next != null){

            if(temp.next.data == val){
                Node newNode = new Node(ele, temp.next);
//                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }

            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {12, 14, 16, 18};
        Node head = convertArr(arr);

        // insertion At Head
//        head = insertAtHead(head, 100);
//                head = new Node(100, head);


        // insertion At Tail
//        head = insertionAtLast(head, 100);



        // insertion At kth pos
//        head = insertionAtK(head, 100,4);


        // insertion At kth pos
        head = insertionBeforeValue(head, 100,14);
        print(head);
    }
}
