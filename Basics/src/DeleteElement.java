// DELETE AN ELEMENT AT A SPECIFIED POSITION IN AN ARRAY

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);

        int size = in.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = in.nextInt();
        }

        int pos = in.nextInt();


        if(pos<=0 || pos>size+1){
            System.out.println("Invalid Position!!!!");
        }
        else{
            for (int i = pos - 1; i < size - 1; i++) {        // 2 3
                arr[i] = arr[i + 1];
            }

            size--;

            System.out.print("Elements of array after delete are: ");
            for (int i = 0; i < size; i++) {
                System.out.printf("%d ", arr[i]);
            }
        }
    }
}
