import java.util.*;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {-3,2,1};
        int k = 6;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        // BruteForce
//        int maxLen = 0;
//        for(int i=0; i<nums.length; i++){
//            int sum = 0;
//            for(int j=i; j<nums.length; j++){
//                sum+=nums[j];
//                if(sum > k) break;       // remove if -ves are there in array
//                if(sum==k) maxLen = Math.max(maxLen, j-i+1);
//            }
//        }
//        return maxLen;



        // Better -> O(n log n) and o(n)  ---> work for all especially -ve's (OPTIMAL then)
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        for(int i=0; i<nums.length; i++){
            // keep adding sum
            sum += nums[i];

            // if equal then max take
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);     // we are just adding so no need to take max it is by default but ok
            }

            // if remainSum is in map then reverse engineering technique
            int remain = sum - k;       // just like prefixSum-k
            if(map.containsKey(remain)){
                int len = i - map.get(remain);
                maxLen = Math.max(maxLen, len);
            }

            // keep updating map with sum by checking for 0 condition also
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;




        // Optimal -> O(2n)  --> works only for +ve and 0's not for -ve's
//        int left = 0, right = 0, maxLen = 0, sum = nums[0];
//
//        while(right< nums.length){
//            // shrink window if sum > k by maintaining window size
//            if(left<=right && sum > k){
//                sum-=nums[left];
//                left++;
//            }
//
//            if(sum==k) maxLen = Math.max(maxLen, right-left+1);
//
//            // compute sum
//            right++;
//            if(right<nums.length) sum+=nums[right];
//        }
//        return maxLen;
    }
}
