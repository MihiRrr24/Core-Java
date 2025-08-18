// https://leetcode.com/problems/left-and-right-sum-differences/description/

import java.util.Arrays;

public class leftRightSum {
    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        int[] ans = leftRightDifference(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        for(int i=0; i<nums.length-1; i++){
            leftSum[i+1] = leftSum[i]+nums[i];
        }

        for(int j=nums.length-2; j>=0; j--){
            rightSum[j] = rightSum[j+1]+nums[j+1];
        }

        int[] ans = new int[nums.length];
        for(int k=0; k<nums.length; k++){
            ans[k] = Math.abs(leftSum[k]-rightSum[k]);
        }
        return ans;
    }
}
