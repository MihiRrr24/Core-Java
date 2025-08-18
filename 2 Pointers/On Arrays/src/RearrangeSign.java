// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/

import java.util.Arrays;

public class RearrangeSign {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        int[] res = rearrangeArray(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] rearrangeArray(int[] nums){
        int even = 0, odd =1;
        int[] result = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] > 0){
                result[even] = nums[i];
                even+=2;
            }
            else{
                result[odd] = nums[i];
                odd+=2;
            }
        }

        return result;
    }
}
