// Here is my thought process for solving this problem:
// Before diving into the solution, one key insight is that we can 
// use the same approach as in the anagram problem. The only difference is that
// we compute the occurrence of each number instead of each character. Computing
// the frequency of each number allows us to figure out if we have duplicates 
// in a row, column, or box. With this simple insight we decompose the problem into
// three subproblems:
// - checking if a row is valid
// - checking if a column is valid
// - checking if a box is valid.
// We can then combine the results to figure out if this is a valid Sudoku board.

// The early returns might be "ugly" but according to problem statement we need to return
// "true" of "false" if the Sudoku board is valid or not.

// Another thing worth mentioning is that we need the i 0 to 3 and j 0 to 3 to 
// nested loop to iterate through the boxes, the key insight here is that we
// need to advance by 3 to get to the next box. This is because the boxes are 3x3.
// Hence the need to use these code isValidBox(board, i * 3, j * 3)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;

        for (int i = 0; i < 9; i++) {
            result = isValidRow(board, i);

            if (!result) {
                return false;
            }

            result = isValidColumn(board, i);

            if (!result) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result = isValidBox(board, i * 3, j * 3);

                if (!result) {
                    return false;
                }
            }
        }

        return result;
    }

    private boolean isValidRow(char[][] board, int row) {
        return !hasDuplicates(board[row]);
    }

    private boolean isValidColumn(char[][] board, int column) {
        char[] chars = new char[9];

        for (int i = 0; i < 9; i++) {
            chars[i] = board[i][column];
        }

        return !hasDuplicates(chars);
    }

    private boolean isValidBox(char[][] board, int row, int column) {
        char[] chars = new char[9];
        int k = 0;

        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                chars[k++] = board[i][j];
            }
        }

        return !hasDuplicates(chars);
    }

    private boolean hasDuplicates(char[] arr) {
        int[] count = new int[10];

        for (char c: arr) {
            if (c == '.') {
                continue;
            }

            count[c - '0']++;

            if (count[c - '0'] > 1) {
                return true;
            }
        }

        return false;
    }
}
