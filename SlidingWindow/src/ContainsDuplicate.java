// https://leetcode.com/problems/contains-duplicate-ii/

import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1,0,1,1}; int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        /* BRUTE FORCE
        int left = 0, right = left+1;

        while(right<nums.length){

            if(nums[left]==nums[right]){
                if(Math.abs(left-right) <= k){
                    return true;
                }
            }

            right++;
            if(right == nums.length && left<nums.length-2){
                left++;
                right = left+1;
            }
        }
        return false;
        */





        /* Using set -> O(n) and O(K) */
        // Set<Integer> st = new HashSet<>();
        // for(int i=0; i<nums.length; i++){
        //     // if duplicate present (k+1 element checks just one position ago)
        //     if(st.contains(nums[i])) return true;

        //     st.add(nums[i]);

        //     // maintain window size
        //     if(st.size() > k){
        //         st.remove(nums[i-k]);
        //     }
        // }

        // return false;





        /* Using Map -> O(n) and O(n) */
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++){

            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i]) <= k){
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}
