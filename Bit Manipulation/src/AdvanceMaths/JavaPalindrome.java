package AdvanceMaths;

import java.util.Scanner;

public class JavaPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(isPalindrome(n)){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }

    public static boolean isPalindrome(int n){
        int rev = n;
        int ans=0;
        while(rev>0){
            int digit = rev%10;
            ans = ans*10+digit;
            rev = rev/10;
        }

        return (ans==n);
    }
}
