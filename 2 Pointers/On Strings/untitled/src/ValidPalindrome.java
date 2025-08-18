// https://leetcode.com/problems/valid-palindrome/

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^0-9a-zA-Z]","").toLowerCase();

        char[] str = s.toCharArray();
        int left=0, right=str.length-1;

        while(left<right){
            if(str[left] != str[right]) return false;
            left++; right--;
        }
        return true;
    }
}
