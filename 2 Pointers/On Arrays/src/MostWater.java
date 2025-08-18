// https://leetcode.com/problems/container-with-most-water/description/

public class MostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int ans = Integer.MIN_VALUE;

        while(left<right){
            // Coz the container is rectangle find the length and breadth
            int length = Math.min(height[left], height[right]);
            int breadth = right-left;

            // Now find currentArea
            int currentArea = length*breadth;

            // Store the max Area
            ans = Math.max(ans, currentArea);

            // Move the left and right pointers
            if(height[left] < height[right]) left++;
            else right--;
        }

        return ans;
    }
}
