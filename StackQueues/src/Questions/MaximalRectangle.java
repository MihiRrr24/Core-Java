// https://leetcode.com/problems/maximal-rectangle/

package Questions;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;

        int[][] prefixSum = new int[row][column];

        for(int j=0; j<column; j++){
            int sum = 0;
            for(int i=0; i<row; i++){
                sum += (matrix[i][j] - '0');
                if(matrix[i][j] == '0') sum = 0;
                // else sum += 1;
                prefixSum[i][j] = sum;
            }
        }

        int maxArea = Integer.MIN_VALUE;
        for(int k=0; k<row; k++){
            maxArea = Math.max(maxArea, maxRectangle(prefixSum[k]));
        }
        return maxArea;
    }

    public static int maxRectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = heights.length;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse-pse-1));
        }
        return maxArea;
    }
}
