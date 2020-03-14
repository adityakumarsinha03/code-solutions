/*

Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

Solution:

int Solution::isValidSudoku(const vector<string> &a){
    map<char, int>m;
    for(int i = 0; i<9; i++){
        for(int j = 0; j<9; j++){
            if(a[i][j] != '.' && m.find(a[i][j]) == m.end()){
                m[a[i][j]] = 1;
            }
            else if(a[i][j] != '.' && m[a[i][j]] == 1){
                return 0;
            }
        }
        m.clear();
    }
    for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(a[j][i] != '.' && m.find(a[j][i]) == m.end()){
                    m[a[j][i]] = 1;
                }
                else if(a[j][i] != '.' && m[a[j][i]] == 1){
                    return 0;
                }
            }
            m.clear();
        }
    for(int i = 0; i<9; i+=3){
            for(int k = 0; k<3; k++){
                for(int j = i; j<i+3; j++){
                    if(a[k][j] != '.' && m.find(a[k][j]) == m.end()){
                        m[a[k][j]] = 1;
                    }
                    else if(a[k][j] != '.' && m[a[k][j]] == 1){
                        return 0;
                    }
                }
            }
            m.clear();
        }
    for(int i = 0; i<9; i+=3){
            for(int k = 3; k<6; k++){
                for(int j = i; j<i+3; j++){
                    if(a[k][j] != '.' && m.find(a[k][j]) == m.end()){
                        m[a[k][j]] = 1;
                    }
                    else if(a[k][j] != '.' && m[a[k][j]] == 1){
                        return 0;
                    }
                }
            }
            m.clear();
        }
        for(int i = 0; i<9; i+=3){
            for(int k = 6; k<9; k++){
                for(int j = i; j<i+3; j++){
                    if(a[k][j] != '.' && m.find(a[k][j]) == m.end()){
                        m[a[k][j]] = 1;
                    }
                    else if(a[k][j] != '.' && m[a[k][j]] == 1){
                        return 0;
                    }
                }
            }
            m.clear();
        }
    return 1;
}
