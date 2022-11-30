public class GameOfLife {

    GameOfLife()
    {

        StdIn.setFile(input1.txt);
        public int rows = StdIn.readInt();

        StdIn.setFile(input2.txt);
        public int cols = StdIn.readInt();
        
        //one line for each row of alive or dead cells
        //loop through num of rows and fill in 2d array with boolean value
        
        boolean[][] board = new boolean[rows][cols];
        
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                StdIn.setFile(input3.txt);
                board[i][j] = StdIn.readBoolean();
            }
        }
    }
  
    public boolean getCellState(int row, int col)
    {
        if(board[row][col])
        {
            return true;
        }
        else if(!board[row][col])
        {
            return false;
        }
    }

    public boolean isAlive(int row, int col) //or can call getCellState 
    {
        boolean dead = false;
        for(int i=0; i<row; i++)
        {
           for(int j=0; j<col; j++)
           {
              if(arr[i][j] == dead)  return false;
           }
        }
        return true;
    }

    public int numOfAliveNeighbors(int row, int col)
    {

        int r = board.length;
        int c = board[r].length;
        int alive = 0;

        //case 1: if input cell is on the corner = max 3 neighbors

        if((row==0 && col==0) ||
            (row==0 && col==c-1) ||
            (row==r-1 && col==0) ||
            (row==r-1 && col==c-1) )
            {
                //check if neigboring cell alive
                //if alive, increment counter
                alive++;
                //else leave alone
            }

        //case 2: if input cell is on border(excluding corner) = max 5 neighbors

        else if((row==0 && col!=0) ||
            (row==0 && col!=c-1) ||
            (row==r-1 && col!=0) ||
            (row==r-1 && col!=c-1) )
            {
                //check if neigboring cell alive
                //if alive increment counter
                alive++;
                //else leave alone
            }

        //case 3: any other input cell(in middle) = max 8 neighbors

        else{
                //correlates to any other cell in grid
                        //check if neigboring cell alive
                        //if alive increment counter
                        alive++;
                        //else leave alone
                    }
        return alive;

    }

    public void computeNewGrid(boolean[][]board, int row, int col)
    {
        int[][] nextgen = new int[row][col];
 
        for (int l = 0; l < row; l++)
        {
            for (int m = 0; m < col; m++)
            {
                //convert boolean array to int (0=false,1=true)
                //then loop through and find num of alive neigbors
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                      if ((l+i>=0 && l+i<row) && (m+j>=0 && m+j<col))
                        aliveNeighbours += nextgen[l + i][m + j];
 

                if ((board[l][m] == 1) && (aliveNeighbours < 2))
                    nextgen[l][m] = 0;
 
                else if ((board[l][m] == 1) && (aliveNeighbours > 3))
                    nextgen[l][m] = 0;
 
                else if ((board[l][m] == 0) && (aliveNeighbours == 3))
                    nextgen[l][m] = 1;
 
                else
                    nextgen[l][m] = board[l][m];
            }
    }   
}

public void nextGeneration()
{
    //done in previous method
}

public void nextGeneration(int n)
{
    for(int i = 0; i<n; i++)
    {
        nextGeneration();
    }
}


}
