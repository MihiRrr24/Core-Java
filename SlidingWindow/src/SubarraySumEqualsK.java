// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.*;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k=3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        // Bruteforce
        // int count = 0;
        // for(int i=0; i<nums.length; i++){
        //     int sum = 0;
        //     for(int j=i; j<nums.length; j++){
        //         sum+=nums[j];

        //         if(sum==k) count++;
        //     }
        // }
        // return count;




        // OPTIMAL
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;

            // just count for remaining using reverse maths for subarrays sum
            int remainToRemove = sum - k;
            count += map.getOrDefault(remainToRemove, 0);

            // store the frequencies of sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
