class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    public int inorderSuccessor(Node root, Node x) {
        if (x.right != null) {
            return minVal(x.right);
        }
        Node succ = null;
        while (root != null) {
            if (x.data<root.data) {
                succ = root;
                root = root.left;
            } else if(x.data>root.data) {
                root = root.right;
            } else {
                break;
            }
        }
        if (succ != null) return succ.data;
        return -1;
    }
    
    public int minVal(Node x) {
        Node current = x;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
}