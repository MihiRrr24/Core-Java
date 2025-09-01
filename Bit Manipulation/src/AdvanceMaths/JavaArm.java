package AdvanceMaths;

public class JavaArm {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        if(isArmstrong(n)){
//            System.out.println("true");
//        } else{
//            System.out.println("false");
//        }

    }

    public static boolean isArmstrong(int n){
        int dup = n;
        int ans = 0;
//        int digits = (int)Math.log10(dup)+1;
        // OR
        int digits = String.valueOf(dup).length();

        while(dup>0){
            int rem = dup%10;
            ans = ans + (int) (Math.pow(rem, digits));
            dup/=10;
        }

        return (ans==n);
    }
}
