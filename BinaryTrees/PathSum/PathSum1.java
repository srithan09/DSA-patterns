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
public class PathSum1 {
    public boolean pathSum(TreeNode root,int targetSum, int sum)
    {
        if(root == null) return false;
        sum = sum + root.data;
        if(root.left == null && root.right == null)
        {
            if(sum == targetSum) return true;
            return false;
        }
        boolean leftSide = pathSum(root.left, targetSum, sum);
        boolean rightSide = pathSum(root.right, targetSum, sum);
        return leftSide || rightSide;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum =0;
        return pathSum(root,targetSum,sum);
    }
    public static void main(String[] args) {
        PathSum1 p1 = new PathSum1();
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
        System.out.println(p1.hasPathSum(root, 22));
    }
}
