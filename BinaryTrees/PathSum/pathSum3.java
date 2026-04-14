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
public class pathSum3 {
    public int pathSum(TreeNode root, int targetSum)
    {
        if(root == null) return 0;
        return countFromNode(root, targetSum) 
            + pathSum(root.left, targetSum) 
            + pathSum(root.right, targetSum);
    }
    public int countFromNode(TreeNode root, long targetSum)
    {
        if(root == null) return 0;
        int count =0;
        if(root.data == targetSum)
        {
            count++;
        }
        long newSum = targetSum - root.data;
        count += countFromNode(root.left, newSum);
        count += countFromNode(root.right, newSum);
        return count;
    }
    public static void main(String[] args) {
        
    }
}
