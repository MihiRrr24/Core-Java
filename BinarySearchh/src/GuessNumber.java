// https://leetcode.com/problems/guess-number-higher-or-lower/?envType=problem-list-v2&envId=binary-search

public class GuessNumber {
    public static void main(String[] args) {
        int n = 10, pick = 6;
        System.out.println(guessNumber(n));
    }

    public static int guessNumber(int n) {
        int start = 1, end = n;

//        while(start<=end){
//            int mid = start+(end-start)/2;
//            int pick = guess(mid);
//
//            if(pick == 0){
//                return mid;
//            }
//            else if(pick == 1){
//                start = mid+1;
//            }
//            else{
//                end = mid-1;
//            }
//        }
        return -1;
    }
}
