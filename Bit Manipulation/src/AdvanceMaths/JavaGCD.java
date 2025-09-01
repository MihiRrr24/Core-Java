package AdvanceMaths;

public class JavaGCD {
    /* BRUTE FORCE APPROACH */
    public static int brutegcd(int n1, int n2){
        int gcd = 1;
        for(int i = 1; i <= Math.min(n1, n2); i++){
            if(n1 % i == 0 && n2 % i == 0){
                gcd = i;
            }
        }
        return gcd;
    }

    /* BETTER APPROACH */
    static int bettergcd(int n1, int n2){
        for(int i = Math.min(n1, n2); i>0 ; i--){
            if(n1 % i == 0 && n2 % i == 0){
                return i;
            }
        }
        return 1;
    }

    /* OPTIMAL APPROACH */
    static int optimalgcd(int n1, int n2){
        while(n1>0 && n2>0){

            if(n1>n2) n1 %= n2;
            else n2 %= n1;
        }
        if(n1 == 0) return n2;
        return n1;
    }

    public static void main(String[] args) {
        int n1 = 20;
        int n2 = 15;
        System.out.println("GCD of "+n1+" and "+n2+" is "+brutegcd(n1, n2));
        System.out.println("GCD of "+n1+" and "+n2+" is "+bettergcd(n1, n2));
        System.out.println("GCD of "+n1+" and "+n2+" is "+optimalgcd(n1, n2));
    }
}
