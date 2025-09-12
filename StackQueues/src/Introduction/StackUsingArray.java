package Introduction;

import java.util.Arrays;

public class StackUsingArray {
    public static int top = -1;
    public static int[] st = new int[10];

    public static void push(int x){
        if(top >= 9){
            System.out.println("Array Size Exceeded");
        }

        top++;
        st[top] = x;
        System.out.println("Pushed "+x);
    }

    public static void pop(){
        if(top == -1) System.out.println("Empty Array");
        System.out.println("Popped "+st[top]);
        st[top] = 0;      // if u want to see element pop then make it 0 else dont write think hypothetically
        top--;
    }

    public static int top(){
        if(top == -1){
            System.out.println("Empty Array");
            return -1;
        }
        return st[top];
    }

    public static int size(){
        return top+1;
    }

    public static void main(String[] args) {
        push(4);
        pop();
        System.out.println();
        System.out.println("Top:- "+top());
        System.out.println();
        push(5);
        push(6);
        push(10);
        System.out.println(Arrays.toString(st));
        System.out.println("Size:- "+size());
        System.out.println();
        System.out.println("Top:- "+top());
    }
}
