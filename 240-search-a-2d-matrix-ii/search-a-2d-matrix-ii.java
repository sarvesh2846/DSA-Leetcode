class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        // start from top right element... 
        int r = 0, c = n-1;

        while(c >= 0 && r < m){
            if(target == matrix[r][c]){
                return true;
            }
            else if(target < matrix[r][c]){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
}