// https://leetcode.com/problems/peak-index-in-a-mountain-array/
// https://leetcode.com/problems/find-peak-element/

public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 1};
        System.out.println("Peak Index -> "+peak_Index(arr));
    }

    public static int peak_Index(int[] arr){
        int start = 0 ;
        int end = arr.length-1;

        while(start<end){
            int mid = start+(end-start)/2;

            // decreasing part of array
            if(arr[mid] > arr[mid+1]){
                end = mid;               // maybe potential answer but look at left also
            }
            else {      // increasing
                start = mid+1;
            }
        }
        return start;
    }
}
