// https://leetcode.com/problems/design-browser-history/

package QuestionsInDLL;

public class DesignBrowserHistory {

//    class BrowserHistory {
//        public class Node{
//            String data;
//            Node next, back;
//
//            Node(String data){
//                this.data = data;
//                this.next = null;
//                this.back = null;
//            }
//        }
//
//        Node curr;
//        public BrowserHistory(String homepage) {
//            curr = new Node(homepage);
//        }
//
//        public void visit(String url) {
//            Node newNode= new Node(url);
//            curr.next = newNode;
//            newNode.back = curr;
//            curr = newNode;
//        }
//
//        public String back(int steps) {
//            while(steps != 0){
//                if(curr.back != null) curr = curr.back;
//                else break;
//                steps--;
//            }
//            return curr.data;
//        }
//
//        public String forward(int steps) {
//            while(steps != 0){
//                if(curr.next != null) curr = curr.next;
//                else break;
//
//                steps--;
//            }
//            return curr.data;
//        }
//    }


}
