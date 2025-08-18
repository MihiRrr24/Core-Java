// Question Link :- https://leetcode.com/problems/two-sum/


import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;

        int[] ans = twoSumVar2(arr, target);
        for(int i:ans) System.out.print(i+" ");
    }

    public static int[] twoSumVar2(int[] arr, int target){
        // BruteForce
//        for(int i=0; i<arr.length-1; i++){
//            for(int j=i+1; j< arr.length; j++){
//                if(arr[i]+arr[j]==target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[] {-1, -1};


        // OPTIMIZED ONE
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            int moreNeed = target-num;

            if(map.containsKey(moreNeed)) return new int[]{map.get(moreNeed), i};

            map.put(num, i);
        }

        return new int[]{-1, -1};
    }
}
