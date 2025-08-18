// https://leetcode.com/problems/rotate-array/description/

import java.util.Arrays;

public class RightRotate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums ,k);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return;

        k = k%n;
        if(k>n) return;

        reverse(nums, 0, n-1);
        reverse(nums, k, n-1);
        reverse(nums, 0, k-1);

    }
}
