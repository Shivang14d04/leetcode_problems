
import java.util.*;

public class BinaryTreePreorderTraversal {

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

        public void preorder(TreeNode node, List<Integer> list) {
            if (node == null) {
                return;
            }

            list.add(node.val);

            preorder(node.left, list);

            preorder(node.right, list);
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();

            preorder(root, list);
            return list;

        }
    }
}
