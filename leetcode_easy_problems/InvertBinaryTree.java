
import java.util.*;

public class InvertBinaryTree {

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

    class Solution {

        public TreeNode invertTree(TreeNode root) {

            if (root == null) {
                return root;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {

                TreeNode current = queue.poll();

                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;

                if (current.right != null) {
                    queue.offer(current.right);
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }

            }
            return root;
        }
    }

    class Solution2 {

        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);  // Go deep into left subtree
            TreeNode right = invertTree(root.right); // Then right subtree

            root.left = right;  // Swap them
            root.right = left;

            return root;
        }
    }
}
