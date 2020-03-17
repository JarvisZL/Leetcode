/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    private Node[] Solve(Node ptr){
        //ret[0] is min, ret[1] is max
        Node[] ret = new Node[2];
        if(ptr.left == null && ptr.right == null){
            ptr.left = ptr.right = ptr;
            ret[0] = ptr;
            ret[1] = ptr;
            return ret;
        }
        else if(ptr.left != null && ptr.right == null){
            Node[] tmp = Solve(ptr.left);
            //parent link with the largest kid
            ptr.left = tmp[1];
            tmp[1].right = ptr;
            //smallest link with the largest
            tmp[0].left = ptr;
            ptr.right = tmp[0];
            //return
            ret[0] = tmp[0];
            ret[1] = ptr;
            return ret;
        }
        else if(ptr.left == null && ptr.right != null){
            Node[] tmp = Solve(ptr.right);
            //parent link with the smallest kid
            ptr.right = tmp[0];
            tmp[0].left = ptr;
            //smallest link with the largest
            ptr.left = tmp[1];
            tmp[1].right = ptr;
            //return
            ret[0] = ptr;
            ret[1] = tmp[1];
            return ret;
        }
        else {
            Node[] l = Solve(ptr.left);
            Node[] r = Solve(ptr.right);
            //parent link with the left largest kid
            ptr.left = l[1];
            l[1].right = ptr;
            //parent link with the right smallest kid
            ptr.right = r[0];
            r[0].left = ptr;
            //smallest link with the largest
            l[0].left = r[1];
            r[1].right = l[0];
            //return
            ret[0] = l[0];
            ret[1] = r[1];
            return ret;
        }
    }
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        return Solve(root)[0];
    }
}