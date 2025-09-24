// https://leetcode.com/problems/trapping-rain-water/

package Questions;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int ans = trap(height);
        System.out.println(ans);
    }

    public static int trap(int[] height) {
        // BETTER
        int total = 0, n = height.length;
        int[] prefix = new int[n];

        prefix[0] = height[0];
        for(int i=1; i<n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }


        // int[] suffix = new int[n];
        // suffix[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--){
        //     suffix[i] = Math.max(suffix[i+1], height[i]);
        // }

        // for(int i=0; i<n; i++){
        //     if(height[i]<prefix[i] && height[i]<suffix[i]){
        //         total+=Math.min(prefix[i], suffix[i]) - height[i];
        //     }
        // }

        int rMax = height[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            total += Math.min(prefix[i], rMax) - height[i];
        }
        return total;






        // OPTIMAL
        // int lMax = 0,rMax = 0,total = 0,left = 0, right=height.length-1;

        // while(left<right){
        //     if(height[left] <= height[right]){
        //         if(lMax > height[left])
        //         {
        //             total += lMax - height[left];
        //         }
        //         else{
        //             lMax = height[left];
        //         }
        //         left++;
        //     }
        //     else{
        //         if(rMax > height[right])
        //         {
        //             total += rMax-height[right];
        //         }
        //         else{
        //             rMax = height[right];
        //         }
        //         right--;
        //     }
        // }

        // return total;
    }
}
