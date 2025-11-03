public class Solution {

    // Solve Sudoku using Backtracking
    public boolean solveSudoku(char[][] board) {
        return solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;

                            if (solve(board))
                                return true;
                            else
                                board[row][col] = '.'; // backtrack
                        }
                    }
                    return false;
                }
            }
        }
        return true; // solved
    }

    // Constraint checking module for pruning invalid moves
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false; // column check
            if (board[row][i] == c) return false; // row check
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false; // subgrid check
        }
        return true;
    }
}
