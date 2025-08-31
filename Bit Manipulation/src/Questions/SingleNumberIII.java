// https://leetcode.com/problems/single-number-iii/

package Questions;

import java.util.Arrays;

public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        int[] ans = singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] singleNumber(int[] nums) {
        // Step 1
        long xor = 0;
        for(int i:nums){
            xor = xor^i;
        }

        // Step 2
        long rightmost = xor & (-xor);

        // Step 3
        int b1 = 0, b2 = 0;
        for(int j:nums){
            if( (j & rightmost) != 0){
                b1 = b1^j;
            }
            else{
                b2 = b2^j;
            }
        }

        return new int[]{b1, b2};
    }
}
