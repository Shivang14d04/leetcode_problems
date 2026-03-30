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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q== null)return true;
       Queue<TreeNode> one = new LinkedList<>();
       Queue<TreeNode> two = new LinkedList<>();
       one.offer(p);
       two.offer(q);

       while(!one.isEmpty() && !two.isEmpty()){
        int size  = one.size();
        for(int i  =0;i<size;i++){
            TreeNode temp = one.poll();
            TreeNode temp2 = two.poll();

            if(temp==null && temp2 == null) continue;
            if(temp == null || temp2 == null || temp.val != temp2.val)return false;

             one.offer(temp.left);
            one.offer(temp.right);
            two.offer(temp2.left);
            two.offer(temp2.right);
        }
       }
       return true; 
    }
}