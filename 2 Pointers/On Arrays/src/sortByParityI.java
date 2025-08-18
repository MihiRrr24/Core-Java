// https://leetcode.com/problems/sort-array-by-parity/description/

import java.util.Arrays;

public class sortByParityI {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        int [] arr = sortArrayByParityI(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArrayByParityI(int[] nums) {
        int i=0, j=nums.length-1;

        while(i<j){
            if(nums[i]%2 != 0 && nums[j]%2==0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
            else if(nums[i]%2==0){
                i++;
            }
            else{
                j--;
            }
        }

        return nums;
    }
}
