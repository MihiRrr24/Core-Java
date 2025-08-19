// https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1

package QuestionsInDLL;

import java.util.ArrayList;
import java.util.List;

public class PairsWithSum {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        Node head = convertArr2DLL(arr);
        print(head);
        ArrayList<ArrayList<Integer>> pairSum = findPairsWithGivenSum(5, head);
        System.out.println(pairSum);
    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {

        // BRUTEFORCE
//        Node temp1 = head;
//        ArrayList<ArrayList<Integer>> pairSum = new ArrayList<>();
//
//        while(temp1 != null){
//            Node temp2 = temp1.next;
//
//            while(temp2 != null && temp1.data+ temp2.data <= target){
//                if(temp1.data + temp2.data == target){
//                    pairSum.add(new ArrayList<>(List.of(temp1.data, temp2.data)));
//                }
//
//                //move pointers for every element
//                temp2 = temp2.next;
//            }
//            temp1 = temp1.next;
//        }
//        return pairSum;




        // OPTIMAL
        Node left = head, right = findTail(head);
        ArrayList<ArrayList<Integer>> pairSum = new ArrayList<>();

        while (left.data < right.data) {
            if (left.data + right.data == target) {
                pairSum.add(new ArrayList<>(List.of(left.data, right.data)));
                left = left.next;
                right = right.prev;
            } else if (left.data + right.data < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return pairSum;
    }

    public static Node findTail(Node head) {
        Node tail = head;
        while (tail.next != null) tail = tail.next;
        return tail;
    }
}