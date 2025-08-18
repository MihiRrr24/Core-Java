// https://leetcode.com/problems/apply-operations-to-an-array/description/

import java.util.Arrays;

public class ApplyOpsToArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        int[] result = applyOperations(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] applyOperations(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i]*=2;
                nums[i+1] = 0;
            }
        }

        int i=-1;

        // Place i pointer to first element i.e. 0 in array
        for(int k = 0; k<nums.length; k++){
            if(nums[k] == 0){
                i=k;
                break;
            }
        }
        if(i==-1) return nums;     // check if there is no 0

        // Place j pointer to after i element in array
        for(int j=i+1; j<nums.length; j++){
            // if it is non zero element swap it with 0
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }

        return nums;
    }
}
