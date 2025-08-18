// https://leetcode.com/problems/sort-array-by-parity-ii/description/

import java.util.Arrays;

public class sortByParityII {
    public static void main(String[] args) {
        int[] nums = {2, 3};
        int [] arr = sortArrayByParityII(nums);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        int even = 0, odd = 1;

        while(even < nums.length && odd < nums.length){
            if(nums[even]%2 == 0){
                even += 2;             // Correct place so move on
            }
            else if(nums[odd]%2 != 0){
                odd += 2;               // Correct place so move
            }
            else{                       // if both are opposite
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;

                even+=2; odd+=2;
            }
        }

        return nums;
    }
}
