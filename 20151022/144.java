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
    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归前序遍历
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // HashSet<TreeNode> hash = new HashSet<TreeNode>();
        if(root == null){
            return result;
        }
        stack.push(root);
        while(stack.size() != 0){
            TreeNode node = stack.pop();
            // if(hash.contains(node)){
            //     result.add(node.val);
            //     continue;
            // }
            result.add(node.val);
            //stack.push(node);
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