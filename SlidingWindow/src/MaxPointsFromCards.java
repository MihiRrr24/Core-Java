// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class MaxPointsFromCards {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;

        // compute sum first till k window size
        for(int i=0; i<k; i++){
            leftSum += cardPoints[i];
        }

        int maxSum = leftSum, rightSum = 0;
        int rightIndex = cardPoints.length-1;

        for(int j=k-1; j>=0; j--){
            leftSum -= cardPoints[j];
            rightSum += cardPoints[rightIndex--];

            maxSum = Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
}
