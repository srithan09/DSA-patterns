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
    int ans =0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freqMap = new int[10];
        dfs(root,freqMap);
        return ans;
    }
    public void dfs(TreeNode root,int[] freqMap)
    {
        if(root == null) return;
        freqMap[root.data]++;
        if(root.left == null && root.right == null)
        {
            int oddCount  = 0;
            for (int i = 1; i <= 9; i++) {
                if(freqMap[i] %2 !=0)
                {
                    oddCount ++;
                }
            }
            if(oddCount <=1)
            {
                ans++;
            }
        }
        dfs(root.left, freqMap);
        dfs(root.right, freqMap);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        Solution sol = new Solution();
        int ans = sol.pseudoPalindromicPaths(root);
        System.out.println(ans);
        
    }
}
