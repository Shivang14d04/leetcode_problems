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
    List<TreeNode> ans = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       helper(root);
       return ans; 
    }
    public String helper(TreeNode node){
        if(node ==   null) return "#";
        String s = node.val + "," + helper(node.left)+","+ helper(node.right);
        map.put(s,map.getOrDefault(s,0)+1);
        if(map.get(s)==2){
            ans.add(node);
        }
        return s;

    }
}