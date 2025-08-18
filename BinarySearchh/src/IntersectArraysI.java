// https://leetcode.com/problems/intersection-of-two-arrays/?envType=problem-list-v2&envId=binary-search

import java.util.*;

public class IntersectArraysI {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> ls = new HashSet<>();
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
        int k=0;
        for(int num:ls){
            arr[k++] = num;
        }
        return arr;










//        Set<Integer> set1 = new HashSet<>();
//        for (int num : nums1) set1.add(num);
//
//        Set<Integer> set2 = new HashSet<>();
//        for (int num : nums2) set2.add(num);
//
//        // retain only elements present in both sets
//        set1.retainAll(set2);
//
//        int[] result = new int[set1.size()];
//        int i = 0;
//        for (int num : set1) {
//            result[i++] = num;
//        }
//
//        return result;
    }
}
