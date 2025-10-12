// https://leetcode.com/problems/second-largest-digit-in-a-string/

import java.util.ArrayList;
import java.util.List;

public class SecondLargestINstring {
    public static void main(String[] args) {
        System.out.println(secondHighest("dfa12321afd"));
    }

    public static int secondHighest(String s) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                list.add(s.charAt(i) - '0');
            }
        }

        return secondLargest(list);
    }

    public static int secondLargest(List<Integer> ls){
        if(ls.isEmpty()) return -1;
        int slargest = Integer.MIN_VALUE, largest = ls.get(0);

        for(int i=1; i<ls.size(); i++){
            if(ls.get(i) > largest){
                slargest = largest;
                largest = ls.get(i);
            }

            else if(ls.get(i) > slargest && ls.get(i) != largest){
                slargest = ls.get(i);
            }
        }
        return (slargest==Integer.MIN_VALUE) ? -1 : slargest;
    }
}
