// FIND OUT THE PRIME FACTORS OF A NUMBER AND RETURN THE PRODUCT OF THEIR PRIME FACTORS


public class ProductofPrimeFactors {
    public static void main(String[] args) {
        int num = 24;
        System.out.println(primeFactors(num));
    }

    public static int primeFactors(int n){
        int prod = 1;
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                prod*=i;
                while(n%i==0) n/=i;
            }
        }

        if(n>1) prod*=n;
        return prod;
    }
}
