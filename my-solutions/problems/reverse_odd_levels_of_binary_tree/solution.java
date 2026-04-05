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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                    q.offer(node.right);
                }

            }
            level++;

                    if (level % 2 != 0 ) {
                        int [] arr = new int[q.size()];
                        int i = 0;
                        for(TreeNode a: q){
                            arr[i++] = a.val;
                        }
                        int j = q.size()-1;
                        for(TreeNode b :q){
                            b.val = arr[j--];
                        }

                    }

        }
        return root;
    }
}