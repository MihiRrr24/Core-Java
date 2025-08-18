// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

import java.util.Arrays;

public class FirstLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        result[0] = binarySearch(nums, target, true);
        if(result[0] != -1){
            result[1] = binarySearch(nums, target, false);
        }

        return result;
    }

    public static int binarySearch(int[] arr, int key, boolean findIndex){
        int start = 0, end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(key>arr[mid]){
                start = mid+1;
            }
            else if(key<arr[mid]){
                end = mid-1;
            }
            else{
                ans = mid;
                if(findIndex){
                    end=mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return ans;
    }
}
