import java.util.HashSet;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> hs = new HashSet<>();
        int n = grid.length;
        int a = 0, b = 0;
        int expSum = 0, actualSum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){

                actualSum += grid[i][j];

                if(hs.contains(grid[i][j])){
                    a = grid[i][j];
                }
                else{
                    hs.add(grid[i][j]);
                }
            }
        }

        int total = n * n;
        expSum = (total * (total + 1)) / 2;
        b = expSum + a - actualSum; 

        int ans[] = {a, b};

        return ans;
    }
}