import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        String ans = bruteForce(arr, target);
        System.out.println(ans);

        String result = betterForce(arr, target);
        System.out.println(result);
    }

    public static String bruteForce(int[] num, int target){
        for(int i=0; i<num.length-1; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[i] + num[j] == target) return "Yes";
            }
        }
        return "No";
    }

    public static String betterForce(int[] arr, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int moreNeeded = target - num;

            if (map.containsKey(moreNeeded)) {
                return "YES";
            }

            map.put(num, i);
        }
        return "NO";
    }

    public static boolean optimalForce(int[] arr, int target){
        Arrays.sort(arr);
        int left = 0, right = arr.length-1, sum = 0;

        while(left<right){
            sum = arr[left]+arr[right];

            if(sum == target) return true;
            else if(sum<target) left++;
            else right--;
        }
        return false;
    }
}
