// https://leetcode.com/problems/sort-colors/description/

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
//        int cnt0 = 0, cnt1 = 0;
//
//        for(int i:nums){
//            if(i == 0) cnt0++;
//            else if(i == 1) cnt1++;
//        }
//
//        for(int i=0; i<cnt0; i++) nums[i] = 0;
//        for(int i=cnt0; i<cnt0+cnt1; i++) nums[i] = 1;
//        for(int i=cnt0+cnt1; i<nums.length; i++) nums[i] = 2;





        // DUTCH NATIONAL FLAG ALGORITHM
        // TC = O(N)    SC = O(1)
        int low = 0, mid = 0, high = nums.length-1;

        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] arr, int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
