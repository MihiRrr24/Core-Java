// https://leetcode.com/problems/search-insert-position/?envType=problem-list-v2&envId=binary-search

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 8;
        System.out.println(searchInsert(arr, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        return start;
    }
}
