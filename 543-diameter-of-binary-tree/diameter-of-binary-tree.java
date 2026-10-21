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

/*
# MOST IMP FOR CODING QS ON DIAMETER OF TREE

| Calculation                              | Formula                         | Why?                                  |
| ---------------------------------------- | ------------------------------- | ------------------------------------- |
| Height                                   | `Math.max(leftHt, rightHt) + 1` | Counts the current node               |
| Diameter through current node (in edges) | `leftHt + rightHt`              | Counts edges when height counts nodes |
| Diameter through current node (in nodes) | `leftHt + rightHt + 1`          | Counts the current node too           |

*/

class Solution {
    int ans = 0;

    public int height(TreeNode root){
        // Base case
        if(root == null){
            return 0;
        }


        // Recursive call to reach the end
        int leftHt = height(root.left);
        int rightHt = height(root.right);

        // Curr Diam => LeftHT + RightHT
        //Take Max of Till Now Maximum Diam [ans] & Curr Diam...
        ans = Math.max(ans, leftHt + rightHt);

        //Return Current Node Height to upper Nodes
        return Math.max(leftHt, rightHt) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        
        // Call to height func
        height(root);

        // In ans we Store the Maximize diam value
        return ans;
    }
}