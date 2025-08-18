// https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.*;

public class SubarraysWithKChars {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        // BRUTEFORCE
//        Map<Integer,Integer> map= new HashMap<>();
//        int count = 0;
//
//        for(int i=0; i<nums.length; i++){
//            map.clear();
//
//            for(int j=i; j<nums.length; j++){
//                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
//
//                if(map.size() == k){
//                    count++;
//                }
//                else if(map.size() > k) break;
//            }
//        }
//        return count;




        // Optimal -> O(n)
        return solve(nums, k) - solve(nums, k-1);
    }

    public static int solve(int[] nums, int k){
        int left=0, right=0, count=0;
        if(k<0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while(map.size() > k){
                map.put(nums[left], map.getOrDefault(nums[left], 0)-1);

                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }

            count+=(right-left+1);
            right++;
        }
        return count;
    }
}
