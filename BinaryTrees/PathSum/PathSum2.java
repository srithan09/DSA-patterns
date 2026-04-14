import java.util.ArrayList;
import java.util.List;

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
public class PathSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        dfs(root, targetSum, sub);
        return res;
    }
    public void dfs(TreeNode root, int sum, List<Integer> sub) {
        if (root == null) return;
        sum = sum - root.data;
        sub.add(root.data);
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(sub));
            }
            sub.remove(sub.size() - 1);
            return;
        }
        dfs(root.left, sum, sub);
        dfs(root.right, sum, sub);
        sub.remove(sub.size() - 1);
    }
    public static void main(String[] args) {
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
        PathSum2 solution = new PathSum2();
        int targetSum = 7; // Example target sum
        List<List<Integer>> paths = solution.pathSum(root, targetSum);
        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
