// https://www.geeksforgeeks.org/problems/the-celebrity-problem/1

package Questions;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
        {0, 1, 0},
        {0, 1, 1}};
        System.out.println(celebrity(mat));
    }

    public static int celebrity(int[][] mat) {
        // BRUTEFORCE
        // int n = mat.length;
        // int[] ans1 = new int[n];
        // int[] ans2 = new int[n];

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<n; j++){
        //         if(i==j) continue;
        //         if(mat[i][j] == 1){
        //             ans1[j]++;
        //             ans2[i]++;
        //         }
        //     }
        // }

        // for(int i=0; i<n; i++){
        //     if(ans1[i]==n-1 && ans2[i]==0){
        //         return i;
        //     }
        // }
        // return -1;



        // OPTIMAL
        int n = mat.length;
        int top = 0, down = n-1;

        while(top < down){

            if(mat[top][down] == 1){
                top++;
            }
            else{
                down--;
            }
        }

        if(top > down) return -1;

        for(int i=0; i<n; i++){
            if(i==top) continue;

            if(mat[top][i]!=0 || mat[i][top]!=1){
                return -1;
            }
        }
        return down;
    }
}
