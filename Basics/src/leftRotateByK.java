// Question LINK :- https://www.naukri.com/code360/problems/rotate-array_1230543

import java.util.Arrays;
import java.util.Scanner;

public class leftRotateByK {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Enter the positions you want to left shift: ");
        int k = in.nextInt();
        k=k%n;                            //  Handle the position larger than size cases
        int[] temp = new int[n];
//        int tempIndex = 0;
//
//        // Copying the right side from the position to end in array     at the starting
//        for(int i=k; i<n; i++){
//            temp[tempIndex] = arr[i];
//            tempIndex++;
//        }
//
//        // Copying the start to the position in array    at the last
//        for(int i=0; i<k; i++){
//            temp[tempIndex] = arr[i];
//            tempIndex++;
//        }
//
//        // MAKE BOTH ARRAYS EQUAL NOW
//        for(int i=0; i<n; i++){
//            arr[i] = temp[i];
//        }



        // IF we Dont want to use tempIndex ( No significant change but change )
        for(int i=0; i<k; i++){    // storing 1 to k  position elements in temp array
            temp[i] = arr[i];
        }

        for(int i=k; i<n; i++){     // shifting k to n position elements in original array
            arr[i-k] = arr[i];
        }

        for(int i=n-k; i<n; i++){                          // replacing left elements in original array to last
            arr[i] = temp[i-(n-k)];                             // left positions is n-k so we used it
        }

        System.out.println(Arrays.toString(arr));       // // t.c and S.c O(n) and O(n)















//        public static void leftRotate(int[] arr, int k) {                      // t.c and S.c O(n) and O(1)
//            int n = arr.length;
//            k = k % n;  // Handle cases where k > n
//
//            reverse(arr, 0, k - 1);   // Reverse first k elements
//            reverse(arr, k, n - 1);   // Reverse remaining n-k elements
//            reverse(arr, 0, n - 1);   // Reverse the whole array
//        }
    }
}
