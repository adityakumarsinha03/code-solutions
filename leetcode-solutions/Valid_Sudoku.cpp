class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        
        vector<vector<int>> row(9,vector<int>(9,0));
        vector<vector<int>> col(9,vector<int>(9,0));
        vector<vector<int>> box(9,vector<int>(9,0));
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                if(board[i][j]!='.'){
        
                        
                  /* if(i<3){
                    if(j<3){
                        box_no=0;
                    }else if(j<6){
                        box_no=1;
                    }else{
                        box_no=2;
                    }
                }else if(i<6){
                    if(j<3){
                        box_no=3;
                    }else if(j<6){
                        box_no=4;
                    }else{
                        box_no=5;
                    }
                }else{
                    if(j<3){
                        box_no=6;
                    }else if(j<6){
                        box_no=7;
                    }else{
                        box_no=8;
                    }
                }*/     
                    
                int value = board[i][j]-'0' -1;
                    
                int box_no= i/3  *3 + j/3;
                    
               
                i=0; value=5
                if(row[i][value]==1 || col[j][value]==1 || box[box_no][value]==1){
                    return false;
                }
                    row[i][value]=1;
                    col[j][value]=1;
                    box[box_no][value]=1;
        
                }
            }
        }
        return true;
    }
};
