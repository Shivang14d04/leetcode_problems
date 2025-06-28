
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

    class Solution2 {

        public List<Integer> preorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            if (root == null) {
                return list;
            }
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode CurrentNode = stack.pop();
                list.add(CurrentNode.val);

                if (CurrentNode.right != null) {
                    stack.push(CurrentNode.right);
                }
                if (CurrentNode.left != null) {
                    stack.push(CurrentNode.left);
                }
            }
            return list;
        }
    }

    class Solution1 {

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
