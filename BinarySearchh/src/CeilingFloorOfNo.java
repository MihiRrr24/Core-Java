public class CeilingFloorOfNo {
    public static void main(String[] args) {
        int target = 1;
        int[] arr = {2,3,5,9,14,16,18};
        System.out.println("Ceiling of No -> "+ceiling(arr, target));
        System.out.println("Floor of No -> "+floor(arr, target));
    }

    public static int ceiling(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        // what if target is greater than the last element
        if(target > arr[arr.length-1]) return -1;

        while(start<=end){
            int mid = start+(end-start)/2;

            if(target > arr[mid]){
                start = mid+1;
            }
            else if(target < arr[mid]){
                end = mid-1;
            }
            else{
                return mid;
            }
        }
        return start;
    }

    public static int floor(int[] num, int key){
        int start = 0;
        int end = num.length-1;

        while (start<=end){
            int mid = start+(end-start)/2;

            if(key>num[mid]) start = mid+1;
            else if(key<num[mid]) end= mid-1;
            else return mid;
        }
        return end;
    }
}
