package Introduction;

import java.util.Arrays;

public class QueueUsingArray {
    public static int size = 10;
    public static int[] qu = new int[10];
    public static int currSize = 0, start = -1, end = -1;

    public static void push(int x){
        if(currSize == size) System.out.println("Array Size Exceeded");
        if(currSize == 0) { // no elements in array
            start = 0;
            end = 0;
        }
        else{ // if elements are there
            end = (end + 1)%size;
        }

        qu[end] = x;
        currSize++;
        System.out.println("Pushed "+x);
    }

    public static int pop(){
        if(currSize == 0) System.out.println("Empty Array");

        // keep track
        int el = qu[start];
        qu[start] = 0;
        if(currSize == 1){
            start = end = -1; // single element case
        }
        else{
            start = (start+1)%size;
        }
        return el;
    }

    public static int top(){
        if(currSize == 0){
            System.out.println("Empty Array");
            return -1;
        }
        return qu[start];
    }

    public static int size(){
        return currSize;
    }

    public static void main(String[] args) {
        push(3);
        push(2);
        push(4);
        System.out.println();
        System.out.println("Top "+top());
        System.out.println();
        System.out.println("Popped "+pop());
        System.out.println("Popped "+pop());
        System.out.println();
        push(2);
        push(3);
        System.out.println();
        System.out.println("Popped "+pop());
        System.out.println("Popped "+pop());
        System.out.println(Arrays.toString(qu));
        System.out.println("Top:- "+top());

    }
}
