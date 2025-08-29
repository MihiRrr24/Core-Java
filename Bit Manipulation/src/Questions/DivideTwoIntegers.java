// https://leetcode.com/problems/divide-two-integers/

package Questions;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = 22, divisor = 3;
        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
         // Naive
//         int sum = 0, cnt = 0;
//
//         while(sum+divisor < dividend){
//             cnt++;
//             sum += divisor;
//         }
//         return cnt;



        // OPTIMAL
        if(dividend == divisor) return 1;

        // handle -ve cases
        int sign = 1;
        if( (dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0) ){
            sign = -1;
        }

        // in question given 32 bit int are taken so it will overflow-231 then show take long
        // of both divd and divs
        long num = Math.abs((long)dividend);
        long denom = Math.abs((long)divisor);
        long quotient = 0;

        while(num >= denom){
            int cnt = 0;

            while(num >= (denom << (cnt+1))) {
                cnt++;
            }
            quotient += 1L <<cnt;
            num -= (denom << cnt);
        }

        // edge cases
        if(quotient == (1L <<31) && sign == 1) return Integer.MAX_VALUE;
        if(quotient == (1L <<31) && sign == -1) return Integer.MIN_VALUE;

        // add sign and return if -ve
        return (int) ((sign==1) ? quotient : -quotient);
    }
}
