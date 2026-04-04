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
    public TreeNode createBinaryTree(int[][] descriptions) {
       Set<Integer> set = new HashSet<>();
       Map<Integer, TreeNode> map = new HashMap<>();
       for(int [] a: descriptions){
        int parent = a[0];
        int child = a[1];
        int isLeft = a[2];
        map.putIfAbsent(parent, new TreeNode(parent));
        map.putIfAbsent(child, new TreeNode(child));
        if(isLeft == 1){
            map.get(parent).left = map.get(child);
        }
        else{
            map.get(parent).right  = map.get(child);
        }
        set.add(child);
       } 

       for(Map.Entry<Integer,TreeNode> entry : map.entrySet()){
            if(!set.contains(entry.getKey())){
                return entry.getValue();
            }
       }
       return null;


    }
}