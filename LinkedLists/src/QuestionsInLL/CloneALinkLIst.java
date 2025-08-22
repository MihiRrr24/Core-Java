// https://leetcode.com/problems/copy-list-with-random-pointer/

package QuestionsInLL;

public class CloneALinkLIst {
//    public Node copyRandomList(Node head) {
//        if(head == null) return head;
        // Naive Approach
        // Node temp = head;
        // Map<Node, Node> mpp = new HashMap<>();

        // while(temp != null){
        //     Node newNode = new Node(temp.val);
        //     mpp.put(temp, newNode);
        //     temp = temp.next;
        // }

        // temp = head;
        // while(temp != null){
        //     Node copyNode = mpp.get(temp);
        //     copyNode.next = mpp.get(temp.next);
        //     copyNode.random = mpp.get(temp.random);

        //     temp = temp.next;
        // }

        // return mpp.get(head);







        /*      OPTIMAL     */
//        Node temp = head;
//
//        // Step 1 (Insert copynode in between)
//        while(temp != null){
//            Node copyNode = new Node(temp.val);
//            copyNode.next = temp.next;
//            temp.next = copyNode;
//            temp = temp.next.next;
//        }
//
//        // step 2 (connect random pointer)
//        temp = head;
//        while(temp != null){
//            Node copyNode = temp.next;
//            copyNode.random = (temp.random!=null) ? temp.random.next : null;
//            temp = temp.next.next;
//        }
//
//        // step 3 (connect next pointer)
//        Node dummyNode = new Node(-1);
//        Node res = dummyNode;
//        temp = head;
//        while(temp != null){
//            res.next = temp.next;
//            temp.next = temp.next.next;
//
//            res = res.next;
//            temp = temp.next;
//        }
//
//        return dummyNode.next;
//    }
}
