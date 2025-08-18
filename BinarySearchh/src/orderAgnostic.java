public class orderAgnostic {
    public static void main(String[] args) {
        int[] arr = {90, 75, 18, 12, 6, 4, 3, 1};
        int target = 75;
        System.out.println(orderAgnosticBinarySearch(arr, target));
    }

    public static int orderAgnosticBinarySearch(int[] arr, int key){
        int start = 0, end = arr.length-1;
        boolean isAsc = arr[start] < arr[end];

        while (start<=end){
            int mid = start+(end-start)/2;
            if(key == arr[mid]){
                return mid;
            }


            if(isAsc) {
                if (key < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            else{
                if(key > arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}
