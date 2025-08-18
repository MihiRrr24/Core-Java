// https://leetcode.com/problems/valid-perfect-square/?envType=problem-list-v2&envId=binary-search

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPerfectSquare(n));
    }

    public static boolean isPerfectSquare(int num) {
        int start = 1, end = num;

        while(start<=end){
            int mid = start+(end-start)/2;
            long square = (long) mid*mid;

            if(square < num){
                start = mid+1;
            }
            else if(square > num){
                end = mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
