class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int  m = matrix.length;
        int  n = matrix[0].length;

        List<Integer> list = new ArrayList<>();

        int srow = 0, erow = m-1, scol = 0, ecol = n-1;

        while(srow <= erow && scol <= ecol){
            //Top
            for(int i = scol; i <= ecol; i++){
                list.add(matrix[srow][i]);
            }

            //right
            for(int i = srow+1; i <= erow; i++){
                list.add(matrix[i][ecol]);
            }

            //bottom
            for(int i = ecol-1; i >= srow; i--){
                if(srow == erow){
                    break;
                }
                list.add(matrix[erow][i]);
            }

            //left
            for(int i = erow-1; i >= srow+1; i--){
                if(scol == ecol){
                    break;
                }
                list.add(matrix[i][scol]);
            }
            srow++; erow--; scol++; ecol--;
        }
        return list;
    }
}