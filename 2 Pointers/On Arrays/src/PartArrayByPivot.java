// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/

import java.util.Arrays;

public class PartArrayByPivot {
    public static void main(String[] args) {
        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;

        int[] arr = pivotArray(nums, pivot);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] pivotArray(int[] nums, int pivot) {

        /* Time complexity: O(n)
            Space complexity: O(n) */

//        int[] result = new int[nums.length];
//        int left=0;
//
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] < pivot){
//                result[left++] = nums[i];
//            }
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] == pivot){
//                result[left++] = nums[i];
//            }
//        }
//
//        for(int i=0; i<nums.length; i++){
//            if(nums[i] > pivot){
//                result[left++] = nums[i];
//            }
//        }
//
//        return result;





        /* Time complexity: O(n)
            Space complexity: O(1) */

        // int lessCount = 0, equalCount = 0;

        // for(int elem:nums){
        //     if(elem < pivot){
        //         lessCount++;
        //     }
        //     else if(elem == pivot){
        //         equalCount++;
        //     }
        // }

        // int start = 0, mid = lessCount, right = lessCount+equalCount;
        // int[] result = new int[nums.length];

        // for(int elem:nums){
        //     if(elem < pivot){
        //         result[start++] = elem;
        //     }
        //     else if(elem == pivot){
        //         result[mid++] = elem;
        //     }
        //     else{
        //         result[right++] = elem;
        //     }
        // }

        // return result;






        int left = 0, right = nums.length-1;     // For Iteration of original array
        int i = 0, j = nums.length-1;           // For Resultant Array
        int[] result = new int[nums.length];

        while(left<nums.length){
            if(nums[left] < pivot){
                result[i++] = nums[left];
            }
            if(nums[right] > pivot){
                result[j--] = nums[right];
            }

            left++; right--;
        }

        // Fill the remaining Equal elements
        while(i<=j){
            result[i] = pivot;
            i++;
        }

        return result;
    }
}
