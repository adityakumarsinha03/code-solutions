/*  https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1#

A binary tree node has data, pointer to left child
   and a pointer to right child  
struct Node
{
    int data;
    Node* left;
    Node* right;
}; */

/*this  function serializes the binary tree and stores it in the vector A*/

class Solution{

public:  
void serializeUtil(Node* root, vector<int> &vec){
    if(root == NULL){
        vec.push_back(-1);
        return;
    }
        
    vec.push_back(root->data);
    serializeUtil(root->left, vec);
    serializeUtil(root->right, vec);
}
vector<int> serialize(Node *root) {
    vector<int> vec;
    serializeUtil(root, vec);
    return vec;
}
/*this function deserializes the serialized vector A*/
int iter = 0;
void deSerializeUtil(Node* &root, vector<int> &vec){
    if(iter >= vec.size() || vec[iter] == -1){
        iter++;
        return;
    }
    
    root = new Node(vec[iter]);
    iter++;
    
    deSerializeUtil(root->left, vec);
    deSerializeUtil(root->right, vec);
}
Node * deSerialize(vector<int> &vec)
{
    Node* root = NULL;
    deSerializeUtil(root, vec);
    return root;
}
};
