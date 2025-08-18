// https://leetcode.com/problems/3sum/description/

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // TC = O(N3)
//        int n = nums.length;
//        Set<List<Integer>> set = new HashSet<>();
//
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                for(int k=j+1; k<n; k++){
//
//                    if(nums[i]+nums[j]+nums[k]==0){
//                        List<Integer> inner = Arrays.asList(nums[i], nums[j], nums[k]);
//                        inner.sort(null);
//                        set.add(inner);
//                    }
//
//                }
//            }
//        }
//
//        List<List<Integer>> result = new ArrayList<>(set);
//        return result;








//        TC = O(N2 * log(no. of unique triplets))
//        int n = nums.length;
//        Set<List<Integer>> set = new HashSet<>();
//
//        for(int i=0; i<n; i++){
//            Set<Integer> st = new HashSet<>();
//            for(int j=i+1; j<n; j++){
//                int third = -(nums[i]+nums[j]);        // This is the third element
//
//                if(st.contains(third)){
//                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
//                    temp.sort(null);
//                    set.add(temp);
//                }
//                st.add(nums[j]);
//            }
//        }
//
//        List<List<Integer>> result = new ArrayList<>(set);
//        return result;









//        TC = O(N2 + N logN) SC = O(no. of unique triplets)~~O(1)
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            // Check for i is there any duplicate below it except first i then skip
            if(i>0 && nums[i] == nums[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];

                if(sum == 0){
                    List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k]);
                    result.add(ans);
                    j++;
                    k--;

                    while(j<k && nums[j]==nums[j-1]) j++; // check for j and k
                    while(j<k && nums[k]==nums[k+1]) k--; // duplicate elements
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }

        return result;
    }
}
