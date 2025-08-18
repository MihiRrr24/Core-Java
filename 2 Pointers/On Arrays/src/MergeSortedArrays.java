// https://leetcode.com/problems/merge-sorted-array/description/

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}; int m = 3;
        int[] nums2 = {2,5,6}; int n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /* Time complexity: O(m+n)
            Space complexity: O(m+n) */

        int i =0, j=0, k=0;
        int[] arr = new int[m+n];

        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<m){
            arr[k++] = nums1[i++];
        }
        while(j<n){
            arr[k++] = nums2[j++];
        }
        for(int b=0;b<arr.length;b++){
            nums1[b] = arr[b];
        }
        System.out.println(Arrays.toString(nums1));




        /* Time complexity: O((m+n)log(m+n))
            Space complexity: O(1) */

        // int i = m;
        // for (int j = 0; j < n; j++) {
        //     nums1[i] = nums2[j];
        //     i++;
        // }
        // Arrays.sort(nums1);




        /* Time complexity: O(m+n)
            Space complexity: O(1) */

        // int i=m-1, j=n-1, k=m+n-1;

        // while(j>=0){
        //     if(i>=0 && nums1[i] > nums2[j]){
        //         nums1[k--] = nums1[i--];
        //     }
        //     else{
        //         nums1[k--] = nums2[j--];
        //     }
        // }
    }
}
