import java.util.Scanner;

public class Patterns {
//    Develop a program to print the following pattern:
//            +
//            ++
//            +++
//            ++++
    public static void print1(int n){
        for(int i=0; i<n; i++){
            for(int j =0; j<=i; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }


//    Write a program to print the following pattern using nested loops:
//
//             ++++
//            ++++
//             ++++
//            ++++
    public static void print2(int n){
        for(int i=1; i<=n; i++){
            if(i%2!=0) System.out.print(" ");

            for(int j=1; j<=n; j++){
                System.out.print("+");
            }
            System.out.println();
        }
    }





    // PYRAMID PATTERN
    public static void print3(int n){
        for(int i=0; i<n; i++){

            for(int j=0; j<n-i-1; j++){
                System.out.print(" ");
            }

            for (int j=0; j<2*i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
//        print1(n);

//        print2(n);
        print3(n);
    }
}
