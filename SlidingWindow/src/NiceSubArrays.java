// https://leetcode.com/problems/count-number-of-nice-subarrays/

public class NiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k-1);
    }

    public static int solve(int[] nums, int k){
        int left = 0, right = 0, sum = 0, count=0;
        if(k < 0) return 0;

        while(right < nums.length){
            sum += nums[right]%2;

            while(sum > k){
                sum -= nums[left]%2;
                left++;
            }

            count += (right-left+1);
            right++;
        }
        return count;
    }
}
