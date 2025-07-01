
import java.util.*;

public class MaximumDepthOfBinaryTree {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution1 {

        int max = 0;

        public int maxDepth(TreeNode root) {

            TreeNode node = root;
            depth(node, 1);
            return max;

        }

        public void depth(TreeNode node, int length) {
            if (node == null) {
                return;
            }
            max = Math.max(length, max);
            depth(node.left, length + 1);
            depth(node.right, length + 1);
        }
    }

    class Solution2 {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();

                for (int i = 0; i < levelSize; i++) {
                    TreeNode current = queue.poll();

                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
                depth++;
            }
            return depth;
        }
    }

}
