public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int pivot = pivotElement(nums)+1;
        System.out.println("Rotation Count -> "+pivot);
    }

    public static int pivotElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // 4 cases
            int mid = start + (end - start) / 2;

            // out of bound check
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

//             this will not work for duplicate values
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
