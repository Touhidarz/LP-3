import java.util.*;

public class nQueen {
    public static int count;

    public static boolean isSafe(char[][] board, int row, int col){
        //row
        for(int i=0; i<board.length; i++){
            if(board[row][i]=='Q') return false;
        }
        //col
        for(int i=0; i<board.length; i++){
            if(board[i][col]=='Q') return false;
        }
        //upperLeft
        int r=row;
        for(int c=col; c>=0 && r>=0; c--, r--){
            if(board[r][c] == 'Q') return false;
        }
        //upperRight
        r=row;
        for(int c=col; c<board.length && r>=0; c++, r--){
            if(board[r][c] == 'Q') return false;
        }
        //lowerLeft
        r=row;
        for(int c=col; c>=0 && r<board.length; c--, r++){
            if(board[r][c] == 'Q') return false;
        }
        //lowerRight
        r=row;
        for(int c=col; c<board.length && r<board.length; c++, r++){
            if(board[r][c] == 'Q') return false;
        }


        return true;
    }

    public static void NQueen(char[][] board, int row){
        if(row == board.length){
            print(board);
            count++;
            return;
        }

        for(int i=0; i<board.length; i++){
            if(isSafe(board, row, i) == true){
                board[row][i] = 'Q';
                NQueen(board, row+1);
                board[row][i] = 'x';
            }
        }
    }

    public static void print(char[][] board){
        System.out.println("-------------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Queens : ");
        int n = sc.nextInt();
        char[][] board = new char[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = 'x';
            }
        }

        NQueen(board, 0);
        System.out.println("Total solutions : "+count);

        sc.close();
    }
}
