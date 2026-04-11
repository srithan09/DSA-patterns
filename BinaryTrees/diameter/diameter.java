class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}
public class diameter {
    int maxi = 0;
    public int diameterBinaryTree(TreeNode root) {
        height(root);
        return maxi;
    }
    public int height(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        maxi = Math.max(maxi, lh + rh);
        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        diameter d = new diameter();
        
        // Create a complex binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        
        int result = d.diameterBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);
    }
}
