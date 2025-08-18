// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class SearchInRotatedBS {
    public static void main(String[] args) {
        int[] nums = {2,9,2,2,2};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int pivot = pivotElement(nums);

        // if no pivot then array is sorted so normal BS
        if(pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }

        // 3 cases for answer if pivot found

        // case 1 if pivot is target
        if(nums[pivot] == target){
            return pivot;
        }

        // case 2 target > start then reduced search space
        if(target >= nums[0]){
            return binarySearch(nums, target, 0, pivot-1);
        }
        else{
            return binarySearch(nums, target, pivot+1, nums.length-1);
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;

            if(arr[mid] == target) return mid;
            else if(arr[mid]>target) end = mid-1;
            else start=mid+1;
        }
        return -1;
    }

    public static int pivotElement(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            // 4 cases
            int mid = start+(end-start)/2;

            // out of bound check
            if(mid<end && arr[mid] > arr[mid+1]){
                return mid;
            }

            if(mid>start && arr[mid] < arr[mid-1]){
                return mid-1;
            }

            // this will not work for duplicate values
//            if(arr[start] >= arr[mid]){
//                end = mid-1;
//            }
//            else{
//                start = mid+1;
//            }


            //  // if elements at middle, start, end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if(start<end && arr[start] > arr[start+1]){
                    return start;
                }
                start++;

                // check whether end is pivot
                if(end > start && arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;
            }

            // left side is sorted, so pivot should be in right
            else if(arr[start] < arr[end] || arr[start]==arr[mid] && arr[mid] > arr[end]){
                start = mid+1;
            }
            else {
                end=mid-1;
            }
        }

        return -1;
    }
}
