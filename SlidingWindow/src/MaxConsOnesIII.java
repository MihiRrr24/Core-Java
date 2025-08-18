// https://leetcode.com/problems/max-consecutive-ones-iii/

public class MaxConsOnesIII {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0 ,0, 1,1,1,1, 0};
        int k = 2;
        System.out.println("Longest subarray with at most K zeroes is -> "+longestOnes(arr, k));
    }

    public static int longestOnes(int[] nums, int k) {
        /* Bruteforce -> O(n2) and O(1)

        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int zeroesCount = 0;

            for(int j=i; j<nums.length; j++){

                if(nums[j] == 0) zeroesCount++;

                if(zeroesCount <= k){
                    maxLen = Math.max(maxLen, j-i+1);
                }
                else{
                    break;
                }
            }
        }

        return maxLen;  */





        /* Better -> O(2N) and O(1) */
        int left = 0, right = 0, maxLen = 0, zerosCount = 0;

        while (right < nums.length){
            // count zeroes encountered
            if(nums[right] == 0) zerosCount++;

            // move left while maintaining zeroesCount
            if(zerosCount > k){
                if(nums[left] == 0) zerosCount--;
                left++;
            }

            // check for maxLen
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

}
