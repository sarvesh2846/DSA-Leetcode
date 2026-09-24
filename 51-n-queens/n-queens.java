import java.util.*;

class Solution {

    public static boolean isSafe(List<String> board, int row, int col, int n){
        //horizontal
        for(int j = 0 ;j < n; j++){
            if(board.get(row).charAt(j) == 'Q'){
                return false;
            }
        }
        //vertical
         for(int i = 0 ;i < n; i++){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }
        // left diagonal
         for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        // Right diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void nQueens(List<String> board, int row, int n, List<List<String>> ans){
        if(row == n){
            ans.add(new ArrayList<>(board)); // we get our one the sol then immediatly add into ans string 
            return;
        }

        for(int j = 0; j < n; j++){
            if(isSafe(board, row, j, n)){
                
                // Place Queen
                StringBuilder str = new StringBuilder(board.get(row));
                str.setCharAt(j, 'Q');
                board.set(row, str.toString());

                // Recursive call
                nQueens(board, row + 1, n, ans);

                // Backtracking
                str.setCharAt(j, '.');
                board.set(row, str.toString());
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        // BOARD LIST CREATION
        //------------------------------------------
        List<String> board = new ArrayList<>();

        // Create n rows of "...."
        String emptyRow = ".".repeat(n);

        // board => "...." , "....", "....", "...."  
        for(int i = 0; i < n; i++){
            board.add(emptyRow);
        }

        //ANS LIST CREATION
        //---------------------------------------
         // initiase the ans List
        List<List<String>> ans = new ArrayList<>(); // initiase the ans List


        //----------------------------------
        // pass the Lists to call
        nQueens(board, 0, n, ans); // call to fun

        return ans; // only returning the ans List
    }
}