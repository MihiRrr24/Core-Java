public class Implement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 4;
        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] nums, int key){
        int n = nums.length;
        int start = 0, end = n-1;

        while(start<=end){
            // take mid (we are taking like this coz int has limited range value
            // so what if we take a larger value for both then it may exceed int value
            // so we do like this safely
            int mid = start + (end-start)/2;

            if(key > nums[mid]){
                start = mid+1;
            }
            else if(key < nums[mid]){
                end = mid-1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }
}


