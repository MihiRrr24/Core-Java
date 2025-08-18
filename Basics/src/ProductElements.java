// Product of elements except itself


import java.util.Arrays;

public class ProductElements {
    static public void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] nums = productOfElements(arr);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] productOfElements(int[] arr){
        int n = arr.length;

        int prod=1;
        for(int i:arr){
            prod*=i;
        }

        int[] result = new int[n];
        for(int i=0; i<n; i++){
            result[i] = prod/arr[i];
        }
        return result;
    }
}
