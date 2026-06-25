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
class BstIterator{
    Stack<TreeNode> stack;
    private boolean reverse;
    public BstIterator(TreeNode node, boolean reverse){
        stack = new Stack<>();
       this.reverse = reverse;
        pushAll(node);
    }

    public int next(){
        TreeNode curr = stack.pop();
        if(reverse){
            pushAll(curr.left);
        }
        else{
            pushAll(curr.right);
        }
        return curr.val;
    }

    public void pushAll(TreeNode node){
            while(node!=null){
                stack.push(node);
                if(reverse){
                    node = node.right;
                }
                else{
                    node = node.left;
                }
            }
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BstIterator l = new BstIterator(root, false);
        BstIterator r = new BstIterator(root, true);
        int left = l.next();
        int right = r.next();
        while(left<right){
            if(left+right ==k)return true;
            else if(left
            +right < k){
                left = l.next();
            }
            else{
                right = r.next();
            }
        }
        return false;
    }
}