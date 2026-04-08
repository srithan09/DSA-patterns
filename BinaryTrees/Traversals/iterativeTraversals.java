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
}
