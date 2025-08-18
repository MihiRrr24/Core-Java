// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums){
        // BRUTEFORCE
        Set<Integer> st = new HashSet<>();

        for(int i:nums){
            st.add(i);
        }
        int newIndex = 0;
        for(int element : st){
            nums[newIndex++] = element;
        }
        return st.size();




        // OPTIMAL
//        int i=0;
//        for(int j=1; j<nums.length; j++){
//            if(nums[i] != nums[j]){
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return (i+1);
    }
}
