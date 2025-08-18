// https://leetcode.com/problems/range-sum-query-immutable/

class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length+1];

        // prefixSum[0] = 0;
        for(int i=0; i<nums.length; i++){
            // prefixSum[i] = prefixSum[i-1]+nums[i-1];
            prefixSum[i+1] = prefixSum[i]+nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1] - prefixSum[left];

        // if(left == 0)return nums[right];
        // return nums[right]-nums[left-1];
    }
}