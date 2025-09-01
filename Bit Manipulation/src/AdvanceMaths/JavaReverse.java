package AdvanceMaths;

public class JavaReverse {
    public static void main(String[] args) {
        int n = 4568;
        System.out.println(reverse(n));
    }

    public static int reverse(int n){
        int ans = 0;
        while(n>0){
            int digit = n%10;
            ans = ans*10+digit;
            n=n/10;
        }

        return ans;
    }
}
