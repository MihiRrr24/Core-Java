// https://leetcode.com/problems/reverse-words-in-a-string/


public class ReverseWords {
    public static void main(String[] args) {
        String s = "   hello     world     ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        //First reverse the string
        // String st = new StringBuilder(s).reverse().toString();
        // char[] str = st.toCharArray();
        // String ans = "";

        // // Now reverse individually
        // for(int i=0; i<str.length; i++){
        //     String word = "";
        //     while(i<str.length && str[i]!=' '){
        //         word+=str[i++];
        //     }

        //     String res = new StringBuilder(word).reverse().toString();
        //     if(res.length()>0){
        //         ans += ' '+res;
        //     }
        // }

        // return ans.trim();





        // String[] arr = s.trim().split("\\s+");
        // int i=0,j=arr.length-1;
        // while(i<j) {
        //     String t = arr[i];
        //     arr[i] = arr[j];
        //     arr[j] = t;
        //     i++;
        //     j--;
        // }
        // return String.join(" ", arr);





        // Two POINTER APPROACH
        char[] st = s.toCharArray();
        reverse(st, 0, s.length()-1);
        int i=0;         // Pointer keeping track of spaces
        int j=0, k=0;      // Pointers reversing the words

        while(i<s.length()){
            // Movement for ith pointer
            if(st[i] == ' '){
                i++;
                continue;
            }

            while(i<s.length() && st[i]!=' '){  // if i see a char then give it to k and ++
                st[k++] = st[i++];
            }

            // ENd of one word is reached so reverse it just
            reverse(st, j, k-1);
            if(k<st.length) st[k++] = ' ';
            j=k;
        }

        if(k>0 && st[k-1]==' ') k--;  // Remove trailing spaces
        return new String(st, 0, k);
    }

    private static void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}