//Question Link :- https://leetcode.com/problems/number-of-digit-one/description/

public class CountOnesInAll {
    public static void main(String[] args) {
        int n = 1797890803;
//        System.out.println(bruteForce(n));
        System.out.println(optimiZed(n));
    }

    public static int bruteForce(int n){
        int count =0;
        for(int i=1; i<=n; i++){
            int num = i;

            while(num>0){
                if(num%10==1) count++;
                num/=10;
            }
        }
        return count;
    }

    public static int optimiZed(int n){
        int count = 0, place = 1;

        while(place<=n){
            int left = n/(place*10);
            int current = (n/place)%10;
            int right = n%place;

            if(current==0) count+=(left*place);
            else if(current==1) count+=(left*place)+(right+1);
            else count+=(left+1)*place;

            place*=10;
        }
        return count;
    }
}
