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
class Solution{
    public boolean isSameTree(TreeNode p, TreeNode q){
    // Base case
    if (p == null || q == null) {
        return p == q; // till last null all equal 
    }

    // Root values must be equal otherwise false
    if (p.val != q.val) {
        return false;
    }

    // Both left and right subtrees must be identical
    return isSameTree(p.left, q.left) &&
           isSameTree(p.right, q.right);
    }

}





// class Solution {

//     public static boolean isIdentical(TreeNode p, TreeNode q){
//         /*
//                Tree 1                 Tree 2

//                   p        <==>         q
//                 /  \                   /  \
//             null  null              null  null

//             # Means till now all Nodes are same and we reach to end that is null and that also same
//         */
//         // base case --> reach to end 
//         if(p == null || q == null){
//             return p == q;
//         }

//     /*
//         Step by step:

//         1. `p == null` → `true`
//         2. `q == null` → `true`
//         3. `p == null || q == null` → `true`
//         4. `p == q` → `true`, because both references are `null`.
//     */


//         // Root and subRoot are same now check for childs equality till base case hit...
//         return p.val == q.val && 
//         isIdentical(p.left, q.left) && 
//         isIdentical(p.right, q.right);
//     }

//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         //base case
//         // Both null and cond.Equal ===> we Reach to end of tree
//         if(p == null || q == null){
//             return p == q; // we return true... ? 
//         }

//         // Root and subRoot are Same then check for their childs(call to isIdentical)
//         if(p.val == q.val && isIdentical(p, q)){
//             return true;
//         }

//         // if we get something value from any side Left OR Right whatever
//         // If true means => tree are Identical (l.T + r.F = T || l.F + r.T = T)
//         return isSameTree(p.left, q.left) || 
//                 isSameTree(p.right, q.right);
//     }
//}