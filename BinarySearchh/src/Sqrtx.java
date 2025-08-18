// https://leetcode.com/problems/sqrtx/?envType=problem-list-v2&envId=binary-search

public class Sqrtx {
    public static void main(String[] args) {
        int x = 18;
        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        int low = 0, high = x;

        while(low<=high){
            int mid = low+(high-low)/2;
            long square = (long) mid*mid;

            if(square == x){
                return mid;
            }
            // if the squared value is less than target then search forward for more suitable one
            // as here we are comparing squared values not single like array
            else if(square < x){
                low = mid+1;
            }
            // and if greater than come back
            else{
                high = mid-1;
            }
        }

        return high;
    }
}
