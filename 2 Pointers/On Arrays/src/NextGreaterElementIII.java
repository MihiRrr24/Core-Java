public class NextGreaterElementIII {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        // Converting String ARRAY TO Integer array for STORE DIGITS
        String numStr = String.valueOf(n);
        int[] digits = new int[numStr.length()];

        int len = numStr.length();
        for (int i = 0; i < len; i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        int found = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (digits[i] < digits[i + 1]) {
                found = i;
                break;
            }
        }
        if (found == -1) {
            return -1;
        } else {
            for (int i = len - 1; i >= 0; i--) {
                if (digits[i] > digits[found]) {
                    int temp = digits[i];
                    digits[i] = digits[found];
                    digits[found] = temp;
                    break;
                }
            }
            int start = found + 1;
            int end = len - 1;
            while (start < end) {
                int temp = digits[start];
                digits[start] = digits[end];
                digits[end] = temp;
                start++;
                end--;
            }
            int newNum = 0;
            for (int digit : digits) {
                if (newNum > (Integer.MAX_VALUE - digit) / 10) {
                    return -1; // overflow will occur
                }
                newNum = newNum * 10 + digit;
            }

            return newNum;
        }





        /* USING CHAR ARRAY TO STORE DIGITS
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        int index = -1;
        // Find the breakpoint
        for(int i=len-2; i>=0; i--){
            if(digits[i] < digits[i+1]){
                index = i;
                break;
            }
        }

        // If no such index, return -1 (no greater permutation and
        // we dont have to return next one so)
        if(index == -1) return -1;

        // Find the next digit > index but the smallest among them in right
        for(int j = len-1; j>index; j--){
            if(digits[j] > digits[index]){
                char temp = digits[j];
                digits[j] = digits[index];
                digits[index] = temp;
                break;
            }
        }

        // Reverse the right part of index now to make sorted
        reverse(digits, index+1, len-1);

        // Convert back to number the digits array
        long result = Long.parseLong(new String(digits));

        // Check 32-bit integer limit if it is in
        return (result <= Integer.MAX_VALUE) ? (int) result : -1; */
    }

//    private static void reverse(char[] arr, int left, int right){
//        while(left<right){
//            char temp = arr[left];
//            arr[left] = arr[right];
//            arr[right] = temp;
//            left++;
//            right--;
//        }
//    }
}
