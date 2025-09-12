// https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1

package Introduction;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLL {
    public static Node top;
    public static int size = 0;

    public static void push(int x){
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size++;
        System.out.println("Pushed "+x);
    }

    public static void pop(){
        System.out.println("Popped "+top.data);
        top = top.next;
        size--;
    }

    public static int top(){
        if(size != 0) return top.data;
        else return -1;
    }

    public static int size(){
        return size;
    }

    public static void main(String[] args) {
        push(3);
        push(2);
        push(4);
        System.out.println();
        pop();
        System.out.println("Top "+top());
        System.out.println();
        push(2);
        push(3);
        System.out.println();
        pop();
        System.out.println("Top:- "+top());
        System.out.println("Size "+size());
    }
}
