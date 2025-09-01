package AdvanceMaths;

public class JavaPrime {
    public static void main(String[] args) {
        int n=5;
        if(isPrime(n)){
            System.out.println("Ok");
        } else{
            System.out.println("No");
        }
    }

    public static boolean isPrime(int n){
        /* NOOB APPROACH */
//        int count = 0;
//        for(int i=1; i<=n; i++){
//            if(n%i==0) count++;
//        }
//        if(count == 2) return true;

        /* MODIFIED APPROACH */
        int count = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                count++;

                if((n/i) != i) count++;
            }
        }

        if(count == 2) return true;
        return false;
    }
}
