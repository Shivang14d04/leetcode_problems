/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class BSTiterator{
    private Stack<TreeNode> stack;
    private boolean reverse;
    BSTiterator(TreeNode root, boolean isReverse){
        stack = new Stack<>();
        reverse = isReverse;
        addAll(root);
    }
    int next(){
        TreeNode temp = stack.pop();
        if(reverse){
            addAll(temp.right);
        }
        else{
            addAll(temp.left);
        }
        return temp.val;
    }
    public void addAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if(reverse){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
    }
 }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTiterator l = new BSTiterator(root,true);
        BSTiterator r = new BSTiterator(root,false);
        int i = l.next();
        int j = r.next();
            while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }

        return false;

    }
}