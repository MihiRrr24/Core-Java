// https://leetcode.com/problems/reverse-prefix-of-word/description/

public class ReversePrefix {
    public static void main(String[] args) {
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(reversePrefix(word, ch));
    }

    public static String reversePrefix(String word, char ch) {
        int index = -1;
        char[] words = word.toCharArray();

        for(int i=0; i<words.length; i++){
            if(words[i] == ch){
                index = i;
                break;
            }
        }

        if(index == -1) return word;
        else{
            int left = 0, right = index;
            while(left<right){
                char temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++; right--;
            }
            return String.copyValueOf(words);
        }
    }
}
