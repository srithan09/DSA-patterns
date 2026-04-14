class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class pathSum3 {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return countFromNode(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int countFromNode(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int count = 0;

        if (root.data == targetSum) {
            count++;
        }

        long newSum = targetSum - root.data;

        count += countFromNode(root.left, newSum);
        count += countFromNode(root.right, newSum);

        return count;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);

        // FIXED HERE (was -11 earlier)
        root.right.right = new TreeNode(11);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right.right = new TreeNode(1);

        pathSum3 p1 = new pathSum3();
        int ans = p1.pathSum(root, 8);

        System.out.println(ans);  // Expected Output: 3
    }
}