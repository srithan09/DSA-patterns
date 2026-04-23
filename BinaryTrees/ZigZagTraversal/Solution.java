import java.util.*;
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode (int data)
    {
        this.data = data;
    }
}
public class Solution
{
    public ArrayList<ArrayList<Integer>> zigzagTraversal(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();
        boolean flag = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            ArrayList<Integer>  list = new ArrayList<>();
            int q_size = q.size();
            for(int i=0;i<q_size;i++)
            {
                TreeNode node = q.poll();
                list.add(node.data);
                if(node.left != null)
                {
                    q.add(node.left);
                }
                if(node.right != null)
                {
                    q.add(node.right);
                }
            }
            if(flag == false)
            {
                Collections.reverse(list);
            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans = sol.zigzagTraversal(root);
        System.out.println(ans);
    }
}