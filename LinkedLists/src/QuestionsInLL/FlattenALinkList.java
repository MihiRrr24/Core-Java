// https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

package QuestionsInLL;

import java.util.*;
public class FlattenALinkList {

    /*        BRUTE FORCE      */
//    Node flatten(Node root) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        Node temp = root;
//
//        while(temp != null){
//            Node t2 = temp;
//            while(t2 != null){
//                arr.add(t2.data);
//                t2 = t2.bottom;
//            }
//
//            temp = temp.next;
//        }
//
//        Collections.sort(arr);
//        return verticalList(arr);
//    }
//
//    Node verticalList(ArrayList<Integer> arr){
//        if(arr.size() == 0) return null;
//        Node head = new Node(arr.get(0));
//        Node temp = head;
//
//        for(int i=1; i<arr.size(); i++){
//            Node newNode = new Node(arr.get(i));
//            temp.bottom = newNode;
//
//            temp = temp.bottom;
//        }
//        return head;
//    }








    /*      OPTIMAL         */
//    Node flatten(Node root) {
//        if(root == null || root.next == null) return root;
//
//        Node mergeRoot = flatten(root.next);
//        return merge(root, mergeRoot);
//    }
//
//    Node merge(Node list1, Node list2){
//        Node dummyNode = new Node(-1);
//        Node res = dummyNode;
//
//        while(list1 != null && list2 != null){
//            if(list1.data <= list2.data){
//                res.bottom = list1;
//                res = list1;
//                list1 = list1.bottom;
//            }
//            else{
//                res.bottom = list2;
//                res = list2;
//                list2 = list2.bottom;
//            }
//
//            res.next = null;
//        }
//
//        if(list1 != null) res.bottom = list1;
//        else res.bottom = list2;
//        // if(dummyNode.bottom != null) dummyNode.bottom.next = null;
//        return dummyNode.bottom;
//    }
}
