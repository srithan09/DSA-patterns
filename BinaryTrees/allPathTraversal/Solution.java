import java.util.*;
class TreeNode
{
    int data;
    TreeNode right;
    TreeNode left;

    TreeNode(int data)
    {
        this.data = data;
    }
}
public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public  ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        // code here
        func(root, new ArrayList<>());
        return ans;
        
    }
    public void func(TreeNode root, ArrayList<Integer> list)
{
    if(root == null) return;

    list.add(root.data);  

    if(root.left == null && root.right == null)
    {
        ans.add(new ArrayList<>(list));  
    }
    else
    {
        func(root.left, list);
        func(root.right, list);
    }

    list.remove(list.size() - 1); 
}
    public static void main(String[] args) {
         TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        Solution sol = new Solution();
        ArrayList<ArrayList<Integer>> ans  = sol.Paths(root);
        System.out.println(ans);
    }
}
