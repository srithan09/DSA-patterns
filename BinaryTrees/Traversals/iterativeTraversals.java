import java.util.ArrayList;
import java.util.Stack;

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
public class iterativeTraversals {
    public ArrayList<Integer> preOrder(TreeNode root)
    {
        ArrayList<Integer> ans  = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return ans;
        st.push(root);
        while(!st.isEmpty())
        {
            root = st.pop();
            ans.add(root.data);
            if(root.right != null)
            {
                st.push(root.right);
            }
            if(root.left != null)
            {
                st.push(root.left);
            }
        }
        return ans;
    }
    public ArrayList<Integer> inOrder(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> st = new Stack<>();
        while(true)
        {
            if(node != null)
            {
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                ans.add(node.data);
                node = node.right;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        iterativeTraversals it = new iterativeTraversals();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        ArrayList<Integer> preOrderAns = new ArrayList<>();
        preOrderAns  = it.preOrder(root);
        System.out.println(preOrderAns);
    }
}
