// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/

import java.util.*;

public class KDistantIndices {
    public static void main(String[] args) {
        int[] nums = {3,4,9,1,3,9,5};
        int key = 9, k = 1;

        List<Integer> result = findKDistantIndices(nums, key, k);
        System.out.println(result);
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;

        // BruteForce1                      TC = O(n2)   SC = O(n)
        // for(int i=0; i<n; i++){
        //     for(int j=i-k; j<=i+k; j++){
        //         if(j>=0 && j<n && nums[j]==key){
        //             ls.add(i);
        //             break;
        //         }
        //     }
        // }
        // return ls;



        // BruteForce2 (Non Math Solvers)    TC = O(n2)   SC = O(n)
        // for(int j=0; j<n; j++){
        //     if(nums[j] == key) ls.add(j);
        // }

        // Set<Integer> set = new HashSet<>();
        // for(int i=0; i<n; i++){
        //     for(int j:ls){
        //         if(Math.abs(i-j)<=k){
        //             set.add(i);
        //         }
        //     }
        // }

        // List<Integer> result = new ArrayList<>(set);
        // return result;







        // OPTIMAL ONE                          TC = O(N) SC = O(N)
        for(int i=0; i<n; i++){
            if(nums[i] == key){
                int start = Math.max(0, i-k);
                int end = Math.min(n-1, i+k);

                // OPtional IF u use Set
                if(ls.size() != 0){
                    start = Math.max( start, ls.get(ls.size()-1)+1 );
                }

                for(int j=start; j<=end; j++){
                    ls.add(j);
                }
            }
        }

        return ls;
    }
}
