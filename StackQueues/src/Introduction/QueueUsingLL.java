// https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1

package Introduction;

public class QueueUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node start, end;
    public static int size = 0;

    public static void push(int x){
        Node temp = new Node(x);

        if(start == null){
            start = end = temp;
        }
        else{
            end.next = temp;
            end = temp;
        }
        size++;
        System.out.println("Pushed "+x);
    }

    public static void pop(){
        if(start == null){
            System.out.println("Linklist is Empty");
            return;
        }
        System.out.println("Popped "+start.data);
        start = start.next;
        size--;
    }

    public static int top(){
        if(start == null){
            System.out.println("LinkList Empty");
            return -1;
        }
        return start.data;
    }

    public static int size(){
        return size;
    }

    public static void main(String[] args) {
        push(7);
        push(2);
        push(3);
        push(5);
        System.out.println();
        pop();
        System.out.println();
        System.out.println("Top:- "+top());
        System.out.println();
        pop();
        pop();
        System.out.println();
        System.out.println("Top:- "+top());
        System.out.println();
        pop();
        System.out.println();
        System.out.println("Size "+size());
    }
}
