// https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int resultSum = 0;
        int minDifference = Integer.MAX_VALUE;

        for(int i=0; i<n-2; i++){
            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum == target) return sum;
                else if(sum<target) j++;
                else k--;

                int diffWithTarget = Math.abs(sum - target);
                if(diffWithTarget < minDifference){
                    resultSum = sum;
                    minDifference = diffWithTarget;
                }
            }
        }

        return resultSum;
    }
}
