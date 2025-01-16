import java.util.Scanner;

public class Main {

//    Write a program to count the number of digits, alphabets, and special characters in a string
//    using a for loop and if-else conditions.
//    Input: "Hello123!"
//    Output: Alphabets = 5, Digits = 3, Special Characters = 1
    private static void isCount(){
        String str = "Hello123!";

        int alphaCount = 0;
        int digitCount=0;
        int specialCount=0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(Character.isAlphabetic(ch)){
                alphaCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            }
            else{
                specialCount++;
            }
        }
        System.out.println("Alphabets = "+alphaCount);
        System.out.println("Digits = "+digitCount);
        System.out.println("Special Characters = "+specialCount);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        System.out.print("Enter a no : ");
//        int n = in.nextInt();
//
//        for(int i=1; i<=10; i++){
//            System.out.println(n+" X "+i+" = "+n*i);
//        }

        isCount();
    }
}




