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
public class heightTree {
    public int height(TreeNode root)
    {
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        heightTree h1 = new heightTree();
        int ans = h1.height(root);
        System.out.println("The height of the tree  " + ans);
    }
}
