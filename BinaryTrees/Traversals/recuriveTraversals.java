import java.util.ArrayList;
class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode()
    {
        
    }
    TreeNode(int data)
    {
        this.data = data;
    }
}
public class recuriveTraversals {
    public ArrayList<Integer> preOrder(TreeNode root)
    {
        ArrayList<Integer> ans  = new ArrayList<>();

        if(root == null)
        {
            return ans;
        }
        ans.add(root.data);
        ans.addAll(preOrder(root.left));
        ans.addAll(preOrder(root.right));
        return ans;
    }
    public ArrayList<Integer> inOrder(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        ans.addAll(inOrder(root.left));
        ans.add(root.data);
        ans.addAll(inOrder(root.right));
        return ans;
    }
    public ArrayList<Integer> postOrder(TreeNode root)
    {
        ArrayList<Integer> ans  = new ArrayList<>();
        if(root == null)
        {
            return ans;
        }
        ans.addAll(postOrder(root.left));
        ans.addAll(postOrder(root.right));
        ans.add(root.data);
        return ans;
    }
    public static void main(String[] args) {
        recuriveTraversals s1 = new recuriveTraversals();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        ArrayList<Integer> result_preOrder = s1.preOrder(root);
        System.out.println("Preorder Traversal: " + result_preOrder);
        ArrayList<Integer> result_inOrder = s1.inOrder(root);
        System.out.println("Preorder Traversal: " + result_inOrder);
        ArrayList<Integer> result_postOrder = s1.postOrder(root);
        System.out.println("Preorder Traversal: " + result_postOrder);
    }
}
