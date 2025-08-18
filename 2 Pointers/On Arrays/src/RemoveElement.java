// https://leetcode.com/problems/remove-element/description/

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));

    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j=0; j<nums.length; j++){
            if(nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
