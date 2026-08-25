/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        getPathSum(root,0);
        return sum;
    }
  public void  getPathSum(TreeNode root, int currSum){
    if(root==null)return;
         currSum= currSum *10 +root.val;
        if(root.left==null && root.right==null){
            sum+=currSum;
            return;
        }
        getPathSum(root.left,currSum);
        getPathSum(root.right,currSum);

    }
}