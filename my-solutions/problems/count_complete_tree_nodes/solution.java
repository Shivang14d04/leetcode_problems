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
class Solution {

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lh = findLeftHeight( root);
        int rh = findRightHeight( root);
        if(lh == rh){
            return (1<<lh)-1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int findLeftHeight(TreeNode node){
        int h = 0;
        while(node != null){
            h++;
            node = node.left;
        }
        return h;
    }
    public int findRightHeight(TreeNode node){
        int h = 0;
        while(node != null){
            h++;
            node = node.right;
        }
        return h;
    }
}