// https://leetcode.com/problems/intersection-of-two-arrays-ii/?envType=problem-list-v2&envId=binary-search

import java.util.*;

public class IntersectArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ls = new ArrayList<>();
        int i=0, j=0;

        int size1 = nums1.length, size2 = nums2.length;

        while(i<size1 && j<size2){

            if(nums1[i]<nums2[j]) i++;
            else if(nums1[i]>nums2[j]) j++;
            else{
                ls.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] arr = new int[ls.size()];
        for(int k =0;k<ls.size();k++){
            arr[k] = ls.get(k);
        }
        return arr;
    }
}
