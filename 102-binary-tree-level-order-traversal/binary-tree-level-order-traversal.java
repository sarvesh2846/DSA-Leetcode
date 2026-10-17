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
import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ansList = new ArrayList<>();
        
        if(root == null){
            return ansList;
        }

        Queue<TreeNode> q = new LinkedList<>();

        //Intialy Queue...
        q.add(root);
        q.add(null);

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){

            TreeNode cuurNode = q.remove();
            
            // Null is Encountered
            if(cuurNode == null){
                // Add one level to List
                ansList.add(list);

                // All nodes are Explored
                if(q.isEmpty()){
                    break;
                }
                
                // Create a fresh list for next level
                list = new ArrayList<>();

                // Mark the end of the next level
                q.add(null);
            }
            // Specific Node is Encountered
            else {
                list.add(cuurNode.val);

                // Add the CurrNode left & right into q which are Exists

                if(cuurNode.left != null){
                    q.add(cuurNode.left);
                }
                if(cuurNode.right != null){
                    q.add(cuurNode.right);
                }
            }
        }

        return ansList;
    }
}