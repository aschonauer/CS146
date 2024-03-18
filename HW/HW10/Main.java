import java.util.List;
import java.util.ArrayList;

public class Main {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> level_list = new ArrayList<List<Integer>>();
        List<Integer> root_val = new ArrayList<Integer>();
        root_val.add(root.val);
        level_list.add(root_val);
        List<TreeNode> pop_nodes = new ArrayList<TreeNode>();
        pop_nodes.add(root);
        while (!pop_nodes.isEmpty()) {
            int length = pop_nodes.size();
            for (int i = 0; i < length; i++) {
                TreeNode popped = pop_nodes.remove(0);
                if (popped.left != null) {
                    pop_nodes.add(popped.left);
                }
                if (popped.right != null) {
                    pop_nodes.add(popped.right);
                }
            }
            List<Integer> pop_values = new ArrayList<Integer>();
            for (TreeNode node : pop_nodes) {
                pop_values.add(node.val);
            }
            if (!pop_values.isEmpty()) {
                level_list.add(pop_values);
            }
        }
        return level_list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        root.left = node7;
        root.right = node8;

        node7.left = node1;
        node1.left = node4;

        node8.left = node5;
        node8.right = node9;

        node5.right = node2;
        node2.left = node6;

        Main obj = new Main();
        List<List<Integer>> levels = obj.levelOrder(root);
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}