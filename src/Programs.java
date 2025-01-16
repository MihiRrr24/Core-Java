import java.util.Scanner;

import static java.lang.Math.log10;

public class Programs {

    public static boolean isPrime(int n){
        int cnt = 0;
        for(int i=1; i*i<=n; i++){
            if(n%i==0)
                cnt++;

            if((n/i)!=i)
                cnt++;
        }

        if(cnt==2) return true;
        else return false;
    }



    public static void armStrong(int n1, int n2){
        for(int i=n1; i<=n2; i++){
            int check, rem, sum=0;
            check = i;
            int count = (int)log10(check)+1;

            while(check != 0){
                rem = check%10;
                sum=sum+((int)Math.pow(rem, count));
                check/=10;
            }

            if(sum==i){
                System.out.println(i+" is an Armstrong Number");
            }
        }
    }




    //    Write a Java program that takes two boolean values as input and performs
//    the logical AND, OR, and NOT operations on them.
//            Constraints: The input boolean values should be either true or false.
//    Test Cases:
//    Input 1: bool1 = true, bool2 = true
//    Output 1: Logical AND: true
//    Logical OR: true
//    Logical NOT for bool1: false
//    Logical NOT for bool2: false
//    Input 2: bool 1 = true, bool2 = false
//    Output 2: Logical AND: false
//    Logical OR: true
//    Input 3: bool 1 = false, bool2 = true
//    Output 3: Logical AND: false
//    Logical OR: true
//    Input 4: bool 1 = false, bool2 = false
//    Output 4: Logical AND: false
//    Logical OR: false

    public static void logicalOps(boolean value1, boolean value2){
        System.out.println("Logical AND: "+ (value1 && value2));
        System.out.println("Logical OR: "+ (value1 || value2));
        System.out.println("Logical NOT for value1: "+ (!value1));
        System.out.println("Logical NOT for value2: "+ (!value2));
    }




    //    Write a program to take a student's score as input and print their grade
//    based on the following criteria:
//
//    A: 90 and above
//    B: 80 to 89
//    C: 70 to 79
//    D: 60 to 69
//    F: Below 60
    public static void gradeScore(int n){
        if(n>=90){
            System.out.println("O");
        } else if (n >= 80 && n <= 89) {
            System.out.println("A+");
        } else if (n >= 70 && n <= 79) {
            System.out.println("A");
        } else if (n >= 60 && n <= 69) {
            System.out.println("B+");
        }
        else {
            System.out.println("F");
        }
    }





//    Write a program to keep taking numbers as input and print them until the user enters 0.
    public static void untilZero(int n){
        Scanner in = new Scanner(System.in);

        while(n!=0){
            System.out.print("Again input the no: ");
            n=in.nextInt();
            if(n==0) break;
        }
    }





//    Write a simple console-based tic-tac-toe game where two players take turns placing their
//    marks ('X' and 'O') on a 3x3 grid. Use nested loops and conditions to check for a win or draw
    private static void ticTac(){

    }





    // Magic SQUARE






//    Write a program to print the first N numbers of the Fibonacci series using a while loop.
    private static int fibo(int n){
        return 0;
    }




//    Write a program to reverse a string using a for loop





//    Write a program to count the occurrences of a specific digit in a number using a while loop.
//    Input: Number = 123451234, Digit = 2
//    Output: 2 occurrences of 2




//    Write a program to convert a decimal number to binary using a while loop.
//    Input: 10
//    Output: 1010


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        System.out.print("Enter the no: ");
//        int n = in.nextInt();
//        if(isPrime(n)) System.out.println("Yes its a prime no");
//        else System.out.println("No its not prime");


//        System.out.print("Enter num1: ");
//        int n1 = in.nextInt();
//        System.out.print("Enter num2: ");
//        int n2 = in.nextInt();
//        armStrong(n1, n2);


//        System.out.print("bool1 = ");
//        boolean value1 = in.nextBoolean();
//        System.out.print("bool2 = ");
//        boolean value2 = in.nextBoolean();
//        logicalOps(value1, value2);


//        System.out.print("Enter the marks: ");
//        int n = in.nextInt();
//        gradeScore(n);



//        System.out.print("Input the no: ");
//        int n = in.nextInt();
//        untilZero(n);





    }
}
