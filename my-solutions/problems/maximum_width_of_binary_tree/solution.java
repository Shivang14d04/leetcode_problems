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
        if (root == null)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int width = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;
            int minIndex = q.peek().getValue();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.getKey();
                int currIndex = p.getValue() - minIndex;
                if (i == 0)
                    first = currIndex;
                if (i == size - 1)
                    last = currIndex;
                if (node.left != null) {
                    q.offer(new Pair(node.left, currIndex * 2 + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, currIndex * 2 + 2));

                }
            }
            width = Math.max(width, last - first + 1);

        }
        return width;
    }
}

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode _node, int _index) {
        this.node = _node;
        this.index = _index;
    }

    TreeNode getKey() {
        return node;
    }

    int getValue() {
        return index;
    }
}