// https://leetcode.com/problems/reverse-vowels-of-a-string/description/

public class ReverseVowels {
    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length-1;

        while(left<right){
            while(left<right && !isVowel(str[left])) left++;
            while(left<right && !isVowel(str[right])) right--;

            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(str);
    }

    public static boolean isVowel(char c){
        return (c=='a' || c=='e'  || c=='i' || c=='o' || c=='u' || c=='A' || c=='E'  || c=='I' || c=='O' || c=='U');
    }
}
