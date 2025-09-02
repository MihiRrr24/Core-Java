// https://leetcode.com/problems/powx-n/

package AdvanceMaths;

public class PowerExponent {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        double m = n;
        if(m < 0){
            m = (-m);
        }

        double ans = 1;
        while(m > 0){
            if(m % 2 == 1){
                ans *= x;
                m -= 1;
            }
            else{
                m = m/2;
                x = x*x;
            }
        }

        return (n < 0) ? 1.0/ans : ans;
    }
}
