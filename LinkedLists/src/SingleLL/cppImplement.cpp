#include <bits/stdc++.h>
using namespace std;

class Node{
    public:
    int data;
    Node* next;
    
    public:
    Node(int data1, Node* next1){
        data = data1;
        next = next1;
    }
    
    // just short if dont want more parameters
    // public:
    // Node(int data1){
    //     data = data1;
    //     next = nullptr;
    // }
};

int main() {
    //way1
    // Node x = Node(2, nullptr);
    // cout<<x.data;
    // cout<<x.next;
    // Node *y = &x;
    // cout<<y;
    
    
    Node *y = new Node(2, nullptr);
    // cout<<y->data;
    // cout<<y->next;
}
