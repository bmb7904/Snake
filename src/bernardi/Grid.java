// this class creates the grid as a 2D array

package bernardi;

import java.util.List;

public class Grid 
{
        final public int numberOfRows;
        final public int numberOfColumns;
        public int[][] tempGrid;
        
        
    public Grid(int numberOfColumnsAndRows)
    {
        this.numberOfColumns = numberOfColumnsAndRows;
        this.numberOfRows = numberOfColumnsAndRows;
        tempGrid = new int[numberOfRows][numberOfColumns];
    }
    
    public int[][] addSnakeToGrid(List <SnakeParts> snake, Fruit fruit, int[][] incomingGrid )
    {
        
        for(int i = 0; i < snake.size(); i ++)
        {
            // this sets the grid to each component in the snake
            incomingGrid[snake.get(i).icomp][snake.get(i).jcomp] = snake.get(i).order;
        }
        
        incomingGrid[fruit.icompFruit][fruit.jcompFruit] = fruit.ORDER;
        
        
        return incomingGrid;

    }
    
        
    public int[][] createBlankGrid()
   {
       for(int i = 0; i < numberOfRows; i ++)
       {
           for (int j = 0; j < numberOfColumns; j++)
           {
               tempGrid[i][j] = 0;
           }
       }
       
       return tempGrid;
   }
}
