class Solution {

    public static boolean isSafe(char[][] board, int row, int col, char dig){
        // horizontal
        for(int j = 0; j < 9; j++){
            if(board[row][j] == dig){
                return false;
            }
        }
        //vertical
        for(int i = 0; i < 9; i++){
            if(board[i][col] == dig){
                return false;
            }
        }
        //grid
        int srow = (row/3) * 3;
        int scol = (col/3) * 3;

        for(int i = srow; i <= srow+2; i++){
            for(int j = scol; j <= scol+2; j++){
                if(board[i][j] == dig){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int col){
        if(row == 9){ // base case, reach to last 8+1
            return true;
        }

        // upadte conditions
        int nextRow = row, nextCol = col + 1; //move to nxt col after place

        if(nextCol == 9){ // col are over then move nxt row
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != '.'){ // place is not empty. already have No
            return helper(board, nextRow, nextCol);// go to next places
        }

        //place the digit
        for(char dig ='1'; dig <= '9'; dig++){ // try 1-9 place at specifc loc issafe
            if(isSafe(board, row, col, dig)){
                board[row][col] = dig;
                if(helper(board, nextRow, nextCol)){ // get 1st ans
                    return true;
                }
                board[row][col] = '.'; //backtrack and update 
            }
        }
        return false; // Not get ans;
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
}