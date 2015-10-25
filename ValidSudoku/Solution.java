package ValidSudoku;

import java.util.HashSet;

/**
 * Created by Alan on 10/27/14.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        int height = board.length;
        int width = board[0].length;

        for(int i=0;i<height;i++){
            HashSet<Character> tmp = new HashSet<Character>();
            for(int j=0;j<width;j++){
                if(board[i][j]!='.' && !tmp.add(board[i][j])){
                    return false;
                }
            }
        }

        for(int i=0;i<width;i++){
            HashSet<Character> tmp = new HashSet<Character>();
            for(int j=0;j<height;j++){
                if(board[j][i]!='.' && !tmp.add(board[j][i])){
                    return false;
                }
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                HashSet<Character> tmp = new HashSet<Character>();
                for(int m=i*3;m<i*3+3;m++){
                    for(int n=j*3;n<j*3+3;n++){
                        if(board[m][n]!='.' && !tmp.add(board[m][n])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
