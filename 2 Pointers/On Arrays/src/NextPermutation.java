// https://leetcode.com/problems/next-permutation/description/

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int index=-1;
        // Find the breakpoint
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        // if Its the last permutation
        if(index == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        // Find the next elemnt > index but the smallest among them
        for(int j=nums.length-1; j>index; j--){
            if(nums[j] > nums[index]){
                int temp = nums[j];
                nums[j] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        // As it is in decreasing order so just reverse
        reverse(nums, index+1, nums.length-1);
    }

    public static void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
