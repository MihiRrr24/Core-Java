// https://leetcode.com/problems/online-stock-span/

package Questions;

import java.util.List;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {

    }

    class StockSpanner {
        private static class Pair{
            int price;
            int days;

            Pair(int price, int days){
                this.price = price;
                this.days = days;
            }
        }

        private Stack<Pair> st;
        int index;

        List<Integer> ls;

        public StockSpanner() {
            st = new Stack<>();
            index = -1;
        }

        public int next(int price) {
            index++;
            while (!st.isEmpty() && st.peek().price <= price) {
                st.pop();
            }

            int ans = index - (st.isEmpty() ? -1 : st.peek().days);
            st.push(new Pair(price, index));

            return ans;
        }
    }
}
