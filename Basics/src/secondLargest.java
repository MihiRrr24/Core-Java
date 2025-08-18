// Question Link :- https://www.naukri.com/code360/problems/second-largest-element-in-the-array_873375

import java.util.Scanner;

public class secondLargest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {1};

        int secondMaximum = secondLargest(arr);
        System.out.println(secondMaximum);
    }

    public static int secondLargest(int[] arr){
//        sorting(arr); // Sorting first                       // O(N log N + N)    (its the best sort algo case)
//        for(int i:arr) System.out.println(Arrays.toString(arr));
//
//        // Finding second element
        int n = arr.length;
//        int largestElement = arr[n-1];
//        int secondLargest = 0;
//        for (int i = n-2; i >= 0; i--) {
//            if(arr[i] != largestElement){
//                secondLargest = arr[i];
//                break;
//            }
//        }
//        return secondLargest;




        // FInding largest without sorting    o(N+N) = O(2N) or O(N)
//        int largest = arr[0];
//        for(int i:arr){
//            if(i>largest) largest = i;
//        }
//
//        // NOw the second-largest
//        int secondLargest = 0;
//        for(int j=0; j<n; j++){
//            if(arr[j]>secondLargest && arr[j]!=largest){
//                secondLargest = arr[j];
//            }
//        }
//        return secondLargest;






        // OPTIMIZED ONE             O(N)
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(arr[i]>largest){
                secondLargest=largest;
                largest = arr[i];
            }
            else if (arr[i]>secondLargest && arr[i]<largest) {
                secondLargest=arr[i];
            }
        }
        return secondLargest;
    }

    public static void sorting(int[] arr){
        int n = arr.length;
        // BUBBLE SORT
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}