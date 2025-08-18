// INSERT AN ELEMENT AT A SPECIFIED POSITION IN AN ARRAY

import java.util.*;

public class InsertElement {
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);

        int size = in.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        int element = in.nextInt();
        int pos = in.nextInt();
        bruteForce(arr, element, pos);
    }

    public static void bruteForce(int[] arr, int element, int pos){
        int n = arr.length;

        if(pos<=0 || pos>n+1){
            System.out.println("Invalid Position!!!!");
        }
        else{
            int[] newArr = new int[n+1];

            for(int i=0; i<pos-1; i++){
                newArr[i] = arr[i];
            }

            newArr[pos-1] = element;

            for(int i=pos; i<=n; i++){
                newArr[i] = arr[i-1];
            }

            System.out.println(Arrays.toString(newArr));
        }
    }
}
