package Tricks;

public class SwapNos {

    public static void main(String[] args) {
        int a = 2, b = 3;

        // using XOR operator
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+" "+b);


        // temp
//        int temp = a;
//        a=b;
//        b=temp;
//        System.out.println(a+" "+b);


        // add sub logic
//        a = a+b;
//        b = a-b;
//        a = a-b;
//        System.out.println(a+" "+b);
    }
}
