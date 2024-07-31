import org.junit.jupiter.api.Test;

public class ValidSudokuTest {
    char[][] VALID_BOARD = new char[][] {
        {'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    char[][] INVALID_BOARD = new char[][] {
        {'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','1','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}
    };

    @Test
    public void testValidSudoku() {
        System.out.println(isValidSudoku(VALID_BOARD));
        System.out.println(isValidSudoku(INVALID_BOARD));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean result = true;

        for (int i = 0; i < 9; i++) {
            result = isValidRow(board, i);

            if (!result) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
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
