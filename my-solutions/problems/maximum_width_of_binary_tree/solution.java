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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int maxWidth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int minIndex = q.peek().getValue();
            int first = 0; int last = 0;
            for(int i =0;i<size;i++){
                Pair p = q.poll();
                TreeNode node = p.getKey();
                int currentIndex = p.getValue() - minIndex;

                if(i==0){
                    first = currentIndex;
                } 
                if(i==size-1){
                    last = currentIndex;
                }

                if(node.left != null){
                    q.add(new Pair(node.left, currentIndex*2 + 1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, currentIndex*2 +2));
                }
            }
            maxWidth  = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;

    }
}

public class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode n, int i){
        node = n;
        index = i;
    }
    TreeNode getKey(){
        return node;
    }
    int getValue(){
        return index;
    }
}