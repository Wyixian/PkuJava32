/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //非递归后续遍历,左，右，根
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> hash = new HashSet<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(stack.size() != 0){
            TreeNode node = stack.pop();
            if(hash.contains(node)){
                result.add(node.val);
                continue;
            }
            hash.add(node);
            stack.push(node);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
            
        }
        return result;
    }
}