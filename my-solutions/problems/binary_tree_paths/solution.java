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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if(root==null) return ans;
        helper(root,"", ans);
        return ans;
    }
    public void helper(TreeNode node,String path, List<String> ans){
        if(node == null){
            return;
        }
        path += node.val;
        if(node.left == null && node.right == null){
            ans.add(path);
            return;
        }
        path+= "->";
        helper(node.left, path, ans);
        helper(node.right,path,ans);

    }
}