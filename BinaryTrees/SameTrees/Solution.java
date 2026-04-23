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
public class Solution {
    public boolean isSame(TreeNode root1,TreeNode root2)
    {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null)
        {
            return false;
        }
        return (root1.data == root2.data) && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }
    public static void main(String[] args) {
        TreeNode root1= new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);

        // FIXED HERE (was -11 earlier)
        root1.right.right = new TreeNode(11);

        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);

        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);

        root1.left.right.right = new TreeNode(1);
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(-3);

        // FIXED HERE (was -11 earlier)
        root2.right.right = new TreeNode(11);

        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(2);

        root2.left.left.left = new TreeNode(3);
        root2.left.left.right = new TreeNode(-2);

        root2.left.right.right = new TreeNode(1);
        Solution s1 = new Solution();
        System.out.println(s1.isSame(root1, root2));
    }
}
