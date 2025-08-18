// https://leetcode.com/problems/valid-palindrome-ii/

public class ValidPalindromeII {
    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        int left = 0 , right = str.length-1;

        while(left<right){
            if(str[left] != str[right]){
                return (isPalindrome(str, left+1, right) || isPalindrome(str, left, right-1));
            }

            left++;
            right--;
        }

        return true;
    }

    private static boolean isPalindrome(char[] c, int left, int right){
        while(left<=right){
            if(c[left] != c[right]) return false;
            left++; right--;
        }
        return true;
    }
}
