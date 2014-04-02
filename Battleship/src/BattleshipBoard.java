import java.util.*;


public class BattleshipBoard {

    private final int rows;
    private final int cols;

    private char[][] board;

    public BattleshipBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows][cols];
    }

    public void place(Ship[] ships) {

        Arrays.sort(ships, new Comparator<Ship>() {

            @Override
            public int compare(Ship s1, Ship s2) {
                return Integer.valueOf(s1.size).compareTo(Integer.valueOf(s2.size));
            }
        });

        for (int j = 0; j < rows; j++)
            for (int k = 0; k < cols; k++)
                board[j][k] = '.'; 

        char[][] checked = new char[rows][cols];
        Random random = new Random();
        for (int i = ships.length - 1; i >=0; i--) {
            for (int j = 0; j < rows; j++)
                for (int k = 0; k < cols; k++)
                    checked[j][k] = 'U'; 
            boolean placed = false;
            while (! placed) {
                int r = random.nextInt(rows);
                int c = random.nextInt(cols);
                if (checked[r][c] == 'U') {
                    checked[r][c] = 'C'; 
                    if (board[r][c] == '.') {
                        int direction = random.nextInt(4);
                        // 0 = North; 1 = East; 2 = South; 3 = West;
                        if (canPlace(ships[i], r, c, direction)) {
                            place(ships[i], r, c, direction);
                            placed = true;
                        }
                    }               
                }
            }
        }
    }

    private void place(Ship ship, int row, int col, int direction) {
        int size = ship.getSize();
        switch (direction) {
        case 0: // North
            for (int  i = row; i >= row - (size - 1); i--)
                board[i][col] = 'S';
            break;

        case 1: // East
            for (int i = col; i <= col + (size - 1); i++)
                board[row][i] = 'S';
            break;

        case 2: // South
            for (int i = row; i <= row + (size - 1); i++)
                board[i][col] = 'S';
            break;

        default: // West
            for (int i = col; i >= col - (size - 1); i--) 
                board[row][i] = 'S';
            break;
        }       
    }

    private boolean canPlace(Ship ship, int row, int col, int direction) {
        int size = ship.getSize();
        boolean thereIsRoom = true;
        switch (direction) {
        case 0: // North
            if (row - (size - 1) < 0)
                thereIsRoom = false;
            else 
                for (int  i = row; i >= row - (size - 1) && thereIsRoom; i--)
                    thereIsRoom = thereIsRoom & (board[i][col] == '.');
            break;

        case 1: // East
            if (col + (size - 1) >= cols)
                thereIsRoom = false;
            else
                for (int i = col; i <= col + (size - 1) && thereIsRoom; i++)
                    thereIsRoom = thereIsRoom & (board[row][i] == '.');
            break;

        case 2: // South
            if (row + (size - 1) >= rows)
                thereIsRoom = false;
            else
                for (int i = row; i <= row + (size - 1) && thereIsRoom; i++)
                    thereIsRoom  = thereIsRoom & (board[i][col] == '.');
            break;

        default: // West
            if (col - (size - 1) < 0) 
                thereIsRoom = false;
            else
                for (int i = col; i >= col - (size - 1) && thereIsRoom; i--) 
                    thereIsRoom = thereIsRoom & (board[row][i] == '.');
            break;
        }
        return thereIsRoom;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(board[i]));
    }

}