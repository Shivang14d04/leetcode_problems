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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        InorderTraversal(inorder, root);
        int n = inorder.size();
        return helper(inorder, 0, n-1);
    }
    public void InorderTraversal(List<Integer> inorder , TreeNode node){
        if(node == null) return;
        InorderTraversal(inorder, node.left);
        inorder.add(node.val);
        InorderTraversal(inorder, node.right);
    }

    public TreeNode helper( List<Integer> inorder, int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(inorder.get(mid));
        root.left = helper(inorder, start, mid -1);
        root.right = helper(inorder, mid +1, end);
        return root;
    }
}