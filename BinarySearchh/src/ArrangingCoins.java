// https://leetcode.com/problems/arranging-coins/?envType=problem-list-v2&envId=binary-search

public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(arrangeCoins(n));
    }

    public static int arrangeCoins(int n) {
        long start = 1, end = n;

        while(start<=end){
            long mid = start+(end-start)/2;
            long countCoin = (mid * (mid+1))/2;

            // Can take ans as mid bcoz it is our possible answer
            if(n>=countCoin){
                start = mid+1;
            }
            else{            // but this is also correct so why take extra variable
                end = mid-1; // as we have to give the rows(means floor concept) that fulfill the coins
            }
        }
        return (int) end;
    }
}
