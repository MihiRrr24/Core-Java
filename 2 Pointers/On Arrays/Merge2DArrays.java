import java.util.*;

public class Merge2DArrays {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}}, nums2 = {{1,4},{3,2},{4,1}};

        int[][] result = mergeArraysOptimal(nums1, nums2);
        for(int []first : result){
            for(int second:first){
                System.out.print(second+" ");
            }
            System.out.println();
        }
    }

    public static int[][] mergeArraysOptimal(int[][] nums1, int[][] nums2) {
        List<int[]> res = new ArrayList<>();

        int n = nums1.length, m = nums2.length, i=0, j=0;

        while(i<n && j<m){
            // Can take nums1[i][0] as id1 and nums1[i][1] as value 2
            int id1 = nums1[i][0], val1 = nums1[i][1];
            int id2 = nums2[j][0], val2 = nums2[j][1];

            if(id1 == id2){
                res.add(new int[]{id1, val1+val2});
                i++;
                j++;
            }
            else if(id1 < id2){
                res.add(nums1[i++]);
            }
            else{
                res.add(nums2[j++]);
            }
        }

        while(i<n){
            res.add(nums1[i++]);
        }
        while(j<m){
            res.add(nums2[j++]);
        }

        return res.toArray(new int[res.size()][]);
        // Or
        // int[][] result = new int[res.size()][2];
        // for (int k = 0; k < res.size(); k++) {
        //     result[k] = res.get(k);
        // }

        // return result;
    }

    public static int[][] mergeArraysByMap(int[][] nums1, int[][] nums2){
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] nums:nums1){
            map.put(nums[0], nums[1]);
        }

        for(int[] nums:nums2){
            if(map.containsKey(nums[0])){
                map.put(nums[0], map.get(nums[0]) + nums[1]);
            }
            else{
                map.put(nums[0], nums[1]);
            }
        }

        int[][] result = new int[map.size()][2];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            result[i][0] = entry.getKey();
            result[i][1] = entry.getValue();
            i++;
        }

        return result;
    }
}