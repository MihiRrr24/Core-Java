// https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordsIII {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        int i=0;
        int j =0, k=0;

        while(i<str.length){
            if(str[i] == ' '){
                i++;
                continue;
            }

            while(i<str.length && str[i] != ' '){
                str[k] = str[i];
                k++;
                i++;
            }

            reverse(str, j, k-1);

            if(k<str.length) str[k++] = ' ';
            j=k;
        }

        return String.valueOf(str);
    }

    private static void reverse(char[] c, int left , int right){
        while(left<right){
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++; right--;
        }
    }
}
