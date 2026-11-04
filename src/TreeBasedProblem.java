import javax.swing.tree.TreeNode;

public class TreeBasedProblem {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftH = height(node.left);
        if (leftH == -1) return -1;

        int rightH = height(node.right);
        if (rightH == -1) return -1;

        if (Math.abs(leftH - rightH) > 1) return -1;

        return 1 + Math.max(leftH, rightH);
    }
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {this.val = val;this.left = left;this.right = right;}
    }
}

