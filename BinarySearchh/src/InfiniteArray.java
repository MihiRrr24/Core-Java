// https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(searchRange(arr, target));
    }

    static int searchRange(int[] nums, int target){
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > nums[end]) {
            int temp = end + 1; // this is my new start
            // double the box value
            // end = previous end + sizeofbox*2
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(nums, target, start, end);
    }

    public static int binarySearch(int[] arr, int key, int start, int end){
        while(start<=end){
            int mid = start+(end-start)/2;

            if(key==arr[mid]){
                return mid;
            }
            else if(key<arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }

        return -1;
    }
}
